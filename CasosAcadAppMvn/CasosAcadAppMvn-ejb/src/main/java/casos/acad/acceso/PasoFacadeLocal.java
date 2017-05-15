/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.Paso;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author omar
 */
@Local
public interface PasoFacadeLocal {

    void create(Paso paso);

    void edit(Paso paso);

    void remove(Paso paso);

    Paso find(Object id);

    List<Paso> findAll();

    List<Paso> findRange(int[] range);

    int count();
    
    Paso crear(Paso tipoPaso);
    
    Paso editar(Paso tipoPaso);
    
    boolean remover(Paso tipoPaso);
    
    Paso findById(Object id);
    EntityManager getEntityManager();
}
