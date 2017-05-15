/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.RequisitoFacadeLocal;
import casos.acad.casosacaddatalibmvn.Requisito;
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
@Path("/requisito")
public class RequisitoFacadeREST{

    @EJB
    private RequisitoFacadeLocal rfl;

    public RequisitoFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Requisito entity) {
        rfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Requisito entity) {
        rfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        rfl.remove(rfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Requisito find(@PathParam("id") Integer id) {
        return rfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Requisito> findAll() {
        return rfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Requisito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return rfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(rfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.rfl.getEntityManager();
    }
    
}
