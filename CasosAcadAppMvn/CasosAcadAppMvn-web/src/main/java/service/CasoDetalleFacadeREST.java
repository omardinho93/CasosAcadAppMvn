/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import casos.acad.acceso.CasoDetalleFacadeLocal;
import casos.acad.casosacaddatalibmvn.CasoDetalle;
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
@Path("/casodetalle")
public class CasoDetalleFacadeREST{

    //
   @EJB
    private CasoDetalleFacadeLocal CasoDetalleFacade;

    public CasoDetalleFacadeREST() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(CasoDetalle entity) {
         CasoDetalleFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, CasoDetalle entity) {
         CasoDetalleFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
         CasoDetalleFacade.remove( CasoDetalleFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public CasoDetalle find(@PathParam("id") Integer id) {
        return  CasoDetalleFacade.find(id);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalle> findAll() {
        return  CasoDetalleFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<CasoDetalle> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return  CasoDetalleFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf( CasoDetalleFacade.count());
    }

    protected EntityManager getEntityManager() {
        return this.CasoDetalleFacade.getEntityManager();
    }
    
}
