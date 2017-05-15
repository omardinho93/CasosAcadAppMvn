/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.TipoPasoFacadeLocal;
import casos.acad.casosacaddatalibmvn.TipoPaso;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author delsas
 */
@RequestScoped
@Path("/tipopaso")
public class TipoPasoFacadeREST{

    @EJB
    private TipoPasoFacadeLocal tpfl;

    public TipoPasoFacadeREST() {
        //super(TipoPaso.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(TipoPaso entity) {
        tpfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, TipoPaso entity) {
        tpfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        tpfl.remove(tpfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public TipoPaso find(@PathParam("id") Integer id) {
        return tpfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoPaso> findAll() {
        return tpfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<TipoPaso> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return tpfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(tpfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.tpfl.getEntityManager();
    }
    
}
