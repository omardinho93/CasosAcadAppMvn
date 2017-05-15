/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.TipoRequisitoFacadeLocal;
import casos.acad.casosacaddatalibmvn.TipoRequisito;
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
@Path("/tiporequisito")
public class TipoRequisitoFacadeREST{

    @EJB
    private TipoRequisitoFacadeLocal trfl;

    public TipoRequisitoFacadeREST() {
    }

    @POST
    @Consumes({ MediaType.APPLICATION_JSON})
    public void create(TipoRequisito entity) {
         trfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, TipoRequisito entity) {
         trfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
         trfl.remove( trfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public TipoRequisito find(@PathParam("id") Long id) {
        return  trfl.findById(id);
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    public List<TipoRequisito> findAll() {
        return  trfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({ MediaType.APPLICATION_JSON})
    public List<TipoRequisito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return  trfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf( trfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.trfl.getEntityManager();
    }
    
}