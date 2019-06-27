/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Animal;

/**
 *
 * @author tiago
 */
@ManagedBean
@ViewScoped
public class BoletimSaudeBean {

    private Status status;
    private List<Animal> lstAnimal;
    private Animal animal;

    public BoletimSaudeBean() {
        LoginTratadorBean lb = (LoginTratadorBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("loginTratador");
        this.lstAnimal = lb.getTratador().getAnimalList();
        this.animal = new Animal();
        this.status = Status.Default;
    }
    
    public void showRegistroClinico(Animal animal){
        this.status = Status.showRegistroClinico;
        this.animal = animal;
    }
    
    public void back(){
        this.status = Status.Default;
    }

    public List<Animal> getLstAnimal() {
        return lstAnimal;
    }

    public void setLstAnimal(List<Animal> lstAnimal) {
        this.lstAnimal = lstAnimal;
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
    
    

}
