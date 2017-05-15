/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.ProcesoDetalleFacadeLocal;
import casos.acad.casosacaddatalibmvn.ProcesoDetalle;
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
@Path("/procesodetalle")
public class ProcesoDetalleFacadeREST{

    @EJB
    private ProcesoDetalleFacadeLocal pdfl;

    public ProcesoDetalleFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(ProcesoDetalle entity) {
        pdfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, ProcesoDetalle entity) {
        pdfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        pdfl.remove(pdfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ProcesoDetalle find(@PathParam("id") Integer id) {
        return pdfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcesoDetalle> findAll() {
        return pdfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<ProcesoDetalle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return pdfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(pdfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.pdfl.getEntityManager();
    }
    
}
