/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author tiago
 */
@ManagedBean
@RequestScoped
public class PagesBean {

    /**
     * Creates a new instance of PagesBean
     */
    public PagesBean() {
    }

    public String login() {
        return "login?faces-redirect=true";
    }

    public String loginVeterinario() {

        return "loginVeterinario?faces-redirect=true";
    }

    public String newAnimal() {
        return "animalCadastro?faces-redirect=true";
    }

    public String newRotinaTarefas() {
        return "rotinaTarefas?faces-redirect=true";
    }
    
    public String boletimDiario(){
        return "boletimDiario?faces-redirect=true";
    }
    
    public String boletimSaude(){
        return "boletimSaude?faces-redirect=true";
    }
    
    public String agendarConsulta(){
        return "agendarConsulta?faces-redirect=true";
    }
    
    public String consultasRealizadas(){
         return "consultasRealizadas?faces-redirect=true";
    }
    
    public String consultasMarcadas(){
         return "veterinario_consultas?faces-redirect=true";
    }
}
