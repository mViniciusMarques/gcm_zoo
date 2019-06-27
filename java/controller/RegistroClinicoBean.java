/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AgendaDao;
import dao.ConsultaDao;
import dao.MedicamentoDao;
import dao.ReceitaDao;
import dao.RegistroClinicoDao;
import dao.VacinaDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.AgendaConsulta;
import model.Animal;
import model.Consulta;
import model.Medicamento;
import model.Receita;
import model.RegistroClinico;
import model.Vacina;
import model.Veterinario;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class RegistroClinicoBean {

    private Animal animal;
    private AgendaConsulta agendaConsulta;
    private Consulta consulta;
    private RegistroClinico registroClinico;
    private List<Vacina> LstVacinas;
    private List<String> idVacinas;
    private Status status;
    private Veterinario veterinario;
    private Receita receita;
    private List<Medicamento> lstMedicamentos;
    private List<String>idmedicamentos;
    private List<AgendaConsulta>lstAgendaConsulta;

    public RegistroClinicoBean() {
        LoginVeterinarioBean lb = (LoginVeterinarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginVeterinario");
        this.veterinario = lb.getVeterinario();
        this.status = Status.Default;
        this.animal = new Animal();
        this.consulta = new Consulta();
        this.receita = new Receita();
        this.registroClinico = new RegistroClinico();
        this.LstVacinas = RegistroClinicoDao.getInstance().findAllVacinas();
        this.lstMedicamentos = MedicamentoDao.getInstance().findAll();
        this.idVacinas = new ArrayList<>();
        this.idmedicamentos = new ArrayList<>();
        this.lstAgendaConsulta = AgendaDao.getInstance().findByVeterinario(veterinario.getId());
    }

    public void storeRegistroClinico() {
        this.findVacinas(idVacinas);
        this.registroClinico.setBoletimSaudeId(animal.getBoletimSaudeId());
        this.registroClinico.setVeterinarioId(veterinario);
        RegistroClinicoDao.getInstance().save(registroClinico);
        this.finalizarConsulta();
        this.status = Status.Default;
        this.carregarAgendamentos();
    }
    
    public void storeReceita() {
        this.receita.setVeterinarioId(veterinario);
        this.receita.setRotinaCodigo(agendaConsulta.getAnimalCodigo().getRotinaCodigo());
        this.receita.setDataEnvio(new Date());
        buscarMedicamentos(idmedicamentos);
        ReceitaDao.getInstance().save(receita);
        this.status = Status.Consultar;
    }
    
    public void carregarAgendamentos(){
        this.lstAgendaConsulta = AgendaDao.getInstance().findByVeterinario(veterinario.getId());
    }

    private void finalizarConsulta() {
        this.consulta.setDataAtendimento(new Date());
        this.consulta.setHoraAtendimento(horaAtual());
        this.consulta.setAgendaConsultaId(agendaConsulta);
        ConsultaDao.getInstance().save(consulta);
        this.agendaConsulta.setAtendido("sim");
        AgendaDao.getInstance().update(agendaConsulta);
    }

    private String horaAtual() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Date hora = Calendar.getInstance().getTime(); // Ou qualquer outra forma que tem
        String dataFormatada = sdf.format(hora);
        return dataFormatada;
    }

    public void btnConsulta(AgendaConsulta agenda) {
        this.status = Status.Consultar;
        this.animal = agenda.getAnimalCodigo();
        this.agendaConsulta = agenda;
        this.registroClinico = new RegistroClinico();
    }
    
    public void btnAddReceita(){
        this.status = Status.AddReceita;
        this.receita = new Receita();
    }

    private void findVacinas(List<String> idvacinas) {
        for (String id : idvacinas) {
            Vacina vacina = VacinaDao.getInstance().findById(Integer.parseInt(id));
            this.registroClinico.getVacinaList().add(vacina);
        }
    }
    
    public void buscarMedicamentos(List<String>idmedicamentos){
        for(String id : idmedicamentos){
            this.receita.getMedicamentoList().add(MedicamentoDao.getInstance().findById(Integer.parseInt(id)));
        }
    }

    public RegistroClinico getRegistroClinico() {
        return registroClinico;
    }

    public void setRegistroClinico(RegistroClinico registroClinico) {
        this.registroClinico = registroClinico;
    }

    public List<Vacina> getLstVacinas() {
        return LstVacinas;
    }

    public void setLstVacinas(List<Vacina> LstVacinas) {
        this.LstVacinas = LstVacinas;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<String> getIdVacinas() {
        return idVacinas;
    }

    public void setIdVacinas(List<String> idVacinas) {
        this.idVacinas = idVacinas;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public AgendaConsulta getAgendaConsulta() {
        return agendaConsulta;
    }

    public void setAgendaConsulta(AgendaConsulta agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
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

    public List<AgendaConsulta> getLstAgendaConsulta() {
        return lstAgendaConsulta;
    }

    public void setLstAgendaConsulta(List<AgendaConsulta> lstAgendaConsulta) {
        this.lstAgendaConsulta = lstAgendaConsulta;
    }
    
    

}
