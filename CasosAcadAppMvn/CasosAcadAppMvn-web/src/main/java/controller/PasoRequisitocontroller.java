/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.PasoRequisitoFacadeLocal;
import casos.acad.casosacaddatalibmvn.Paso;
import casos.acad.casosacaddatalibmvn.PasoRequisito;
import casos.acad.casosacaddatalibmvn.Requisito;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author delsas
 */
@Named(value = "pasoRequisitocontroller")
@RequestScoped
public class PasoRequisitocontroller {
    @EJB
    private PasoRequisitoFacadeLocal prfl;
    private Paso p=new Paso();
    private Requisito r=new Requisito();
    private PasoRequisito pr=new PasoRequisito();
    private boolean editando;
    /**
     * Creates a new instance of PasoRequisitocontroller
     */
    public PasoRequisitocontroller() {
    }

    public PasoRequisitoFacadeLocal getPrfl() {
        return prfl;
    }

    public void setPrfl(PasoRequisitoFacadeLocal prfl) {
        this.prfl = prfl;
    }

    public Paso getP() {
        return p;
    }

    public void setP(Paso p) {
        this.p = p;
    }

    public Requisito getR() {
        return r;
    }

    public void setR(Requisito r) {
        this.r = r;
    }

    public PasoRequisito getPr() {
        return pr;
    }

    public void setPr(PasoRequisito pr) {
        this.pr = pr;
    }
    
    public void limpiar() {
        this.pr=new PasoRequisito();
        this.p = new Paso();
        this.r = new Requisito();
        this.editando = false;
    }
    
    public void seleccionar(PasoRequisito pr) {
        this.pr = pr;
        this.r = pr.getIdRequisito();
        this.p=pr.getIdPaso();
        this.editando = true;
    }
    
    public void agregar() {
        this.pr.setIdPaso(this.p);
        this.pr.setIdRequisito(this.r);
        this.prfl.create(this.pr);
        this.p = new Paso();
        this.r=new Requisito();
        this.editando = false;
    }
    
    public void editar(){
        if (this.pr.getIdPaso()!= null && this.pr.getIdRequisito() != null) {
            this.pr.setIdPaso(this.p);
            this.pr.setIdRequisito(this.r);
            this.prfl.edit(this.pr);
            limpiar();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
         
    }
    
    public void remover(){
        if (this.pr.getIdPaso() != null && this.pr.getIdRequisito() != null) {
            this.prfl.remove(this.pr);
            limpiar();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
    
}
