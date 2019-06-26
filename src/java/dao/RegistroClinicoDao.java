/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.RegistroClinico;
import model.Vacina;

/**
 *
 * @author tiago
 */
public class RegistroClinicoDao  extends GenericDao<RegistroClinico>{
    
   private static RegistroClinicoDao instance;

    private RegistroClinicoDao() {

    }

    public void save(RegistroClinico object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public List<RegistroClinico> findAll() {
        Query q = em.createNamedQuery("RegistroClinico.findAll");
        return q.getResultList();
    }

    public List<Vacina> findAllVacinas() {
        Query q = em.createNamedQuery("Vacina.findAll");
        return q.getResultList();
    }

    public static RegistroClinicoDao getInstance() {
        if (instance == null) {
            instance = new RegistroClinicoDao();
        }
        return instance;
    } 
    
}
