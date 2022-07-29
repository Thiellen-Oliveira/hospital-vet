/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.Dao;
import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Consulta;

/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class ConsultaControle implements Serializable{
    
    private Dao<Animal> daoAnimal;
    private Dao<Consulta> daoConsulta;
    private List<Animal> animais;
    private Consulta consulta;
    
     @PostConstruct
    public void iniciar() {
        daoAnimal = new Dao(Animal.class);
        daoConsulta = new Dao(Consulta.class);      
       consulta=(new Consulta());
        animais=(daoAnimal.listarTodos());
    }
    
    public void inserir() {
        daoConsulta.inserir(consulta);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Consulta inserida", null));
        consulta = new Consulta();
        
        
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    
    
}
