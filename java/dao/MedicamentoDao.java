/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.Query;
import model.Medicamento;

/**
 *
 * @author tiago
 */
public class MedicamentoDao extends GenericDao<Medicamento> {

    private static MedicamentoDao instance;

    private MedicamentoDao() {
    }

    public List<Medicamento> findAll() {
        Query q = em.createNamedQuery("Medicamento.findAll");
        return q.getResultList();
    }

    public Medicamento findById(int id) {
        return em.find(Medicamento.class, id);
    }

    public static MedicamentoDao getInstance() {
        if (instance == null) {
            instance = new MedicamentoDao();
        }
        return instance;
    }

}
