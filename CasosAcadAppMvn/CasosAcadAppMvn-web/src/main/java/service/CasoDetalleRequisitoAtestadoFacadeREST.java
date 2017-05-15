/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.CasoDetalleRequisitoAtestadoFacadeLocal;
import casos.acad.casosacaddatalibmvn.CasoDetalleRequisitoAtestado;
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
@Path("/casodetallerequisitoatestado")
public class CasoDetalleRequisitoAtestadoFacadeREST{

    @EJB
    private CasoDetalleRequisitoAtestadoFacadeLocal cdrafl;

    public CasoDetalleRequisitoAtestadoFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(CasoDetalleRequisitoAtestado entity) {
        cdrafl.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, CasoDetalleRequisitoAtestado entity) {
       cdrafl.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        cdrafl.remove(cdrafl.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CasoDetalleRequisitoAtestado find(@PathParam("id") Integer id) {
        return cdrafl.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalleRequisitoAtestado> findAll() {
        return cdrafl.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalleRequisitoAtestado> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return cdrafl.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(cdrafl.count());
    }

    protected EntityManager getEntityManager() {
        return this.cdrafl.getEntityManager();
    }
    
}
