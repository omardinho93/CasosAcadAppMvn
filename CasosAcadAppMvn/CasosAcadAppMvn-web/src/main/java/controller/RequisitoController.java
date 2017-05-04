/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.RequisitoFacadeLocal;
import casos.acad.casosacaddatalibmvn.Requisito;
import casos.acad.casosacaddatalibmvn.TipoRequisito;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author omar
 */
@Named(value = "requisitoController")
@ViewScoped
public class RequisitoController implements Serializable {
    private RequisitoFacadeLocal rFacade;
    private boolean editando = false;
    private TipoRequisito t = new TipoRequisito();
    private Requisito r = new Requisito();

    public TipoRequisito getT() {
        return t;
    }

    public void setT(TipoRequisito t) {
        this.t = t;
    }

    public RequisitoFacadeLocal getPasoFacade() {
        return rFacade;
    }

    public RequisitoFacadeLocal getrFacade() {
        return rFacade;
    }

    public void setrFacade(RequisitoFacadeLocal rFacade) {
        this.rFacade = rFacade;
    }


    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    public Requisito getR() {
        return r;
    }

    public void setR(Requisito r) {
        this.r = r;
    }

    public RequisitoController() {
    }

    public List<Requisito> findAlls() {
        return this.rFacade.findAll();
    }

    public void limpiar() {
        this.r = new Requisito();
        this.t = new TipoRequisito();
        this.editando = false;
    }

    public void agregar() {
        this.r.setIdTipoRequisito(this.t);
        this.rFacade.crear(this.r);
        this.r = new Requisito();
        this.t = new TipoRequisito();
        this.editando = false;
    }

    public String borrar() {
        if (this.r.getIdTipoRequisito() != null) {
            this.rFacade.remover(this.r);
            this.r = new Requisito();
            this.t = new TipoRequisito();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";

    }

    public void seleccionar(Requisito p) {
        this.r = p;
        this.t = p.getIdTipoRequisito();
        this.editando = true;
    }

    public String editar() {
        if (this.r.getIdTipoRequisito() != null) {
            this.r.setIdTipoRequisito(this.t);
            this.rFacade.editar(this.r);
            this.r = new Requisito();
            this.t = new TipoRequisito();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }

}
