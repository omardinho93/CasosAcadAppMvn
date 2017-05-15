/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author delsas
 */
@javax.ws.rs.ApplicationPath("ws")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.CasoDetalleFacadeREST.class);
        resources.add(service.CasoDetalleRequisitoAtestadoFacadeREST.class);
        resources.add(service.CasoDetalleRequisitoFacadeREST.class);
        resources.add(service.CasoFacadeREST.class);
        resources.add(service.PasoFacadeREST.class);
        resources.add(service.PasoRequisitoFacadeREST.class);
        resources.add(service.ProcesoDetalleFacadeREST.class);
        resources.add(service.ProcesoFacadeREST.class);
        resources.add(service.RequisitoFacadeREST.class);
        resources.add(service.SolicitudFacadeREST.class);
        resources.add(service.TipoPasoFacadeREST.class);
        resources.add(service.TipoRequisitoFacadeREST.class);
    }
    
}
