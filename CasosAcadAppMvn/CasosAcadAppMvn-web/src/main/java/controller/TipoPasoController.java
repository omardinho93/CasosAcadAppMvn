/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import casos.acad.acceso.TipoPasoFacadeLocal;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.util.List;
import javax.ejb.EJB;
import casos.acad.casosacaddatalibmvn.TipoPaso;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author omar
 */
@Named(value = "tipoPasoController")
@ViewScoped
public class TipoPasoController implements Serializable {

    @EJB
    private TipoPasoFacadeLocal tipoPasoFacade;
    private boolean editando = false;
    private boolean crud = false;

    public boolean isCrud() {
        return crud;
    }

    public void setCrud(boolean crud) {
        this.crud = crud;
    }
    
    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }

    private TipoPaso tp = new TipoPaso();

    public TipoPaso getTp() {
        return tp;
    }

    public void setTp(TipoPaso tp) {
        this.tp = tp;
    }

    public TipoPasoController() {
    }

    public List<TipoPaso> findAll() {
        
        return this.tipoPasoFacade.findAll();
    }

//    public TipoPaso findById(Integer id) {
//        this.seleccionar(this.tipoPasoFacade.findById(id));
//        return this.tp;
//    }
    public void limpiar() {
        this.tp = new TipoPaso();
        this.editando = false;
    }

    public void agregar() {
        this.tipoPasoFacade.crear(this.tp);
        this.tp = new TipoPaso();
        this.editando = false;
    }

    public String borrar() {
        if (this.tp.getIdTipoPaso() != null) {
            this.tipoPasoFacade.remover(this.tp);
            this.tp = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "borrar";

    }

    public void seleccionar(TipoPaso tp) {
        this.tp = tp;
        this.editando = true;
        this.crud = true;
    }

    public String editar() {
        if (this.tp.getIdTipoPaso() != null) {
            this.tipoPasoFacade.editar(this.tp);
            this.tp = new TipoPaso();
        } else {
            System.out.println("no se puede eliminar si no hay seleccionado");
        }
        this.editando = false;
        return "index";
    }
    
    public void cambiarEstado(){
        if(crud==true){
            crud=false;
        }else{
            crud=true;
        }
    }
}
