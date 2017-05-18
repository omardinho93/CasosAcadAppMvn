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
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author omar
 */
@Named(value = "pasoRequisitoController")
@ViewScoped
public class PasoRequisitoController implements Serializable {

    @EJB
    private PasoRequisitoFacadeLocal prFacade;
    private boolean editando = false;
    private Paso p = new Paso();
    private Requisito r = new Requisito();
    private PasoRequisito pr = new PasoRequisito();

    public PasoRequisito getPr() {
        return pr;
    }

    public void setPr(PasoRequisito pr) {
        this.pr = pr;
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

    public PasoRequisitoFacadeLocal getPrFacade() {
        return prFacade;
    }

    public void setPrFacade(PasoRequisitoFacadeLocal prFacade) {
        this.prFacade = prFacade;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public List<PasoRequisito> findAlls() {
        return this.prFacade.findAll();
    }

    public void limpiar() {
        this.pr = new PasoRequisito();
        this.p = new Paso();
        this.r = new Requisito();
        this.editando = false;
    }

    public void agregar() {
        try {
                this.pr.setIdPaso(this.p);
                this.pr.setIdRequisito(this.r);
                this.prFacade.crear(this.pr);
                this.limpiar();
                this.editando = false;
        } catch (Exception e) {

        }
    }

    public String borrar() {
        if (this.pr.getIdPasoRequisito() != null) {
            this.prFacade.remover(this.pr);
            this.limpiar();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";
    }

    public void seleccionar(PasoRequisito pr) {
        this.setPr(pr);
        this.pr.setIdPaso(pr.getIdPaso());
        this.pr.setIdRequisito(pr.getIdRequisito());
        this.setEditando(true);
    }

    public String editar() {
        this.p = new Paso();
        this.r = new Requisito();
        this.prFacade.editar(this.pr);
        this.limpiar();
        return "index";
    }
}
