/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casos.acad.acceso;

import casos.acad.casosacaddatalibmvn.Requisito;
import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;

/**
 *
 * @author omar
 */
@Local
public interface RequisitoFacadeLocal {

    void create(Requisito requisito);

    void edit(Requisito requisito);

    void remove(Requisito requisito);

    Requisito find(Object id);

    List<Requisito> findAll();

    List<Requisito> findRange(int[] range);

    int count();
    
    Requisito crear(Requisito tipoRequisito);
    
    Requisito editar(Requisito tipoRequisito);
    
    boolean remover(Requisito tipoRequisito);
    
    Requisito findById(Object id);  
    EntityManager getEntityManager();
}
