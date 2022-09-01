package controle;

import dao.Dao;
import dao.DaoAnimal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Consulta;
import modelo.Tutor;

/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class NovaConsultaControle implements Serializable {

    private DaoAnimal daoAnimal;
    private Dao<Consulta> daoNovaConsulta;
    private List<Animal> animais;
    private Consulta consulta;
    private List<Tutor> tutores;
    private Dao<Tutor> daoTutor;
    private Tutor tutor;
    
   
    
    
    @PostConstruct
    public void iniciar() {
        daoAnimal = new DaoAnimal();
        daoNovaConsulta = new Dao(Consulta.class);
        daoTutor = new Dao(Tutor.class);
        consulta = (new Consulta());
        tutores = daoTutor.listarTodos();
        
        tutor = new Tutor();
        
         
        
    }

    public void inserir() {
        daoNovaConsulta.inserir(consulta);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Nova Consulta inserida", null));
        consulta = new Consulta();

    }   
    
    
    
    
    
   
    
    public void atualizar(){
        animais = daoAnimal.buscarPorTutor(tutor.getId());
        
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

    public List<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

}
