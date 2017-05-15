/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.CasoDetalleRequisitoFacadeLocal;
import casos.acad.casosacaddatalibmvn.CasoDetalleRequisito;
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
@Path("/casodetallerequisito")
public class CasoDetalleRequisitoFacadeREST{

    @EJB
    private CasoDetalleRequisitoFacadeLocal cdrfl;

    public CasoDetalleRequisitoFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(CasoDetalleRequisito entity) {
        cdrfl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, CasoDetalleRequisito entity) {
        cdrfl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        cdrfl.remove(cdrfl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CasoDetalleRequisito find(@PathParam("id") Integer id) {
        return cdrfl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalleRequisito> findAll() {
        return cdrfl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalleRequisito> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return cdrfl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(cdrfl.count());
    }

    protected EntityManager getEntityManager() {
        return this.cdrfl.getEntityManager();
    }
    
}
