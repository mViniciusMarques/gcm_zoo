/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Consulta;

/**
 *
 * @author tiago
 */
public class ConsultaDao extends GenericDao<Consulta>{
    private static ConsultaDao instance;

    private ConsultaDao() {
        super();
    }

    public void save(Consulta object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }
    
    public List<Consulta>findByVeterinario(int id){
        Query q = em.createQuery("SELECT c FROM Consulta c WHERE c.agendaConsultaId.veterinarioId.id = :id AND c.agendaConsultaId.atendido = 'sim'");
        q.setParameter("id", id);
        return q.getResultList();
    }

    public static ConsultaDao getInstance() {
        if (instance == null) {
            instance = new ConsultaDao();
        }
        return instance;
    }
}
