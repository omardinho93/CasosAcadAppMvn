/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.ProcesoFacadeLocal;
import casos.acad.casosacaddatalibmvn.Proceso;
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
@Path("/proceso")
public class ProcesoFacadeREST{

    @EJB
    private ProcesoFacadeLocal pfl;

    public ProcesoFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Proceso entity) {
        pfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Proceso entity) {
        pfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        pfl.remove(pfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Proceso find(@PathParam("id") Integer id) {
        return pfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Proceso> findAll() {
        return pfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Proceso> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return pfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(pfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.pfl.getEntityManager();
    }
    
}
