/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDao;
import dao.MedicamentoDao;
import dao.ReceitaDao;
import dao.TratadorDao;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.AgendaConsulta;
import model.Medicamento;
import model.Receita;
import model.Veterinario;

/**
 *
 * @author Guitar Jr
 */
@ManagedBean
@RequestScoped
public class receitaBean {

    private Veterinario veterinario;
    private Receita receita;
    private List<Medicamento> lstMedicamentos;
    private List<String>idmedicamentos;
    private AgendaConsulta agenda;

    /**
     * Creates a new instance of receitaBean
     */
    public receitaBean() {
        LoginVeterinarioBean lvt = (LoginVeterinarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginVeterinario");
        this.veterinario = lvt.getVeterinario();
        this.lstMedicamentos = MedicamentoDao.getInstance().findAll();
        this.receita = new Receita();
    }

    public void store() {
        this.receita.setRotinaCodigo(agenda.getAnimalCodigo().getRotinaCodigo());
        this.receita.setDataEnvio(new Date());
        buscarMedicamentos(idmedicamentos);
        ReceitaDao.getInstance().save(receita);
    }
    
    public void buscarMedicamentos(List<String>idmedicamentos){
        for(String id : idmedicamentos){
            this.receita.getMedicamentoList().add(MedicamentoDao.getInstance().findById(Integer.parseInt(id)));
        }
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public List<Medicamento> getLstMedicamentos() {
        return lstMedicamentos;
    }

    public void setLstMedicamentos(List<Medicamento> lstMedicamentos) {
        this.lstMedicamentos = lstMedicamentos;
    }

    public List<String> getIdmedicamentos() {
        return idmedicamentos;
    }

    public void setIdmedicamentos(List<String> idmedicamentos) {
        this.idmedicamentos = idmedicamentos;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    
}
