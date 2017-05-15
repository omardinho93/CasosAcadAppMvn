/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.SolicitudFacadeLocal;
import casos.acad.casosacaddatalibmvn.Solicitud;
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
@Path("c/solicitud")
public class SolicitudFacadeREST{

    @EJB
    private SolicitudFacadeLocal sfl;

    public SolicitudFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Solicitud entity) {
        sfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Solicitud entity) {
        sfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        sfl.remove(sfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Solicitud find(@PathParam("id") Integer id) {
        return sfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findAll() {
        return sfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Solicitud> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return sfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(sfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.sfl.getEntityManager();
    }
    
}
