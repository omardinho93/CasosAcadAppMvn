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
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author omar
 */
@Named(value = "requisitoController")
@ViewScoped
public class RequisitoController implements Serializable {

    @EJB
    private RequisitoFacadeLocal rFacade;
    private boolean editando = false;
    private TipoRequisito t = new TipoRequisito();
    private Requisito r = new Requisito();
    private boolean crud = false;

    public boolean isCrud() {
        return crud;
    }

    public void setCrud(boolean crud) {
        this.crud = crud;
    }

    public TipoRequisito getT() {
        return t;
    }

    public void setT(TipoRequisito t) {
        this.t = t;
    }

    public RequisitoFacadeLocal getPasoFacade() {
        return getrFacade();
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
        return this.getrFacade().findAll();
    }

    public void limpiar() {
        this.setR(new Requisito());
        this.setT(new TipoRequisito());
        this.setEditando(false);
    }

    public void agregar() {
        this.getR().setIdTipoRequisito(this.getT());
        this.getrFacade().crear(this.getR());
        this.setR(new Requisito());
        this.setT(new TipoRequisito());
        this.setEditando(false);
    }

    public String borrar() {
        if (this.getR().getIdTipoRequisito() != null) {
            this.getrFacade().remover(this.getR());
            this.setR(new Requisito());
            this.setT(new TipoRequisito());
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.setEditando(false);
        return "borrar";

    }

    public void seleccionar(Requisito p) {
        this.setR(p);
        this.setT(p.getIdTipoRequisito());
        this.setEditando(true);
        this.setCrud(true);
    }

    public String editar() {
        if (this.getR().getIdTipoRequisito() != null) {
            this.getR().setIdTipoRequisito(this.getT());
            this.getrFacade().editar(this.getR());
            this.setR(new Requisito());
            this.setT(new TipoRequisito());
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.setEditando(false);
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
