/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.PasoFacadeLocal;
import casos.acad.casosacaddatalibmvn.Paso;
import casos.acad.casosacaddatalibmvn.TipoPaso;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author omar
 */
@Named(value = "pasoController")
@ViewScoped
public class PasoController implements Serializable {

    @EJB
    private PasoFacadeLocal pasoFacade;
    private boolean editando = false;
    private TipoPaso t = new TipoPaso();
    private Paso p = new Paso();
    private boolean crud = false;

    public boolean isCrud() {
        return crud;
    }

    public void setCrud(boolean crud) {
        this.crud = crud;
    }

    public TipoPaso getT() {
        return t;
    }

    public void setT(TipoPaso t) {
        this.t = t;
    }

    public PasoFacadeLocal getPasoFacade() {
        return pasoFacade;
    }

    public void setPasoFacade(PasoFacadeLocal pasoFacade) {
        this.pasoFacade = pasoFacade;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public Paso getP() {
        return p;
    }

    public void setP(Paso p) {
        this.p = p;
    }

    public PasoController() {
    }

    public List<Paso> findAlls() {
        return this.pasoFacade.findAll();
    }

    public void limpiar() {
        this.p = new Paso();
        this.t = new TipoPaso();
        this.editando = false;
    }

    public void agregar() {
        this.p.setIdTipoPaso(this.t);
        this.pasoFacade.crear(this.p);
        this.p = new Paso();
        this.t = new TipoPaso();
        this.editando = false;
    }

    public String borrar() {
        if (this.p.getIdTipoPaso() != null) {
            this.pasoFacade.remover(this.p);
            this.p = new Paso();
            this.t = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";

    }

    public void seleccionar(Paso p) {
        this.setP(p);
        this.setT(p.getIdTipoPaso());
        this.setEditando(true);
        this.setCrud(true);
    }

    public String editar() {
        if (this.p.getIdTipoPaso() != null) {
            this.p.setIdTipoPaso(this.t);
            this.pasoFacade.editar(this.p);
            this.p = new Paso();
            this.t = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }

    public void cambiarEstado() {
        if (crud == true) {
            crud = false;
        } else {
            crud = true;
        }
    }

}
