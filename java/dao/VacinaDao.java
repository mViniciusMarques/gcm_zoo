/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Rotina;
import model.Vacina;

/**
 *
 * @author tiago
 */
public class VacinaDao extends GenericDao<Vacina>{
    private static VacinaDao instance;

    private VacinaDao(){
        
    }
    
    public Vacina findById(int id){
        Query q = em.createNamedQuery("Vacina.findById");
        q.setParameter("id", id);
        return (Vacina)q.getSingleResult();
    }
    
    public static VacinaDao getInstance() {
        if (instance == null) {
            instance = new VacinaDao();
        }
        return instance;
    }
}
