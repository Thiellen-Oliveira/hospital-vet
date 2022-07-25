package controle;

import dao.Dao;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Animal;
import modelo.Tutor;

@Named
@ViewScoped
public class GerenciarAnimalControle implements Serializable {

    private Dao<Tutor> daoTutor;
    private Dao<Animal> daoAnimal;
    private List<Tutor> listaTutores;
    private Animal novoAnimal;
    
    
    

    @PostConstruct
    public void iniciar() {
        daoTutor = new Dao(Tutor.class);
        daoAnimal = new Dao(Animal.class);
        setListaTutores(daoTutor.listarTodos());
        setNovoAnimal(new Animal());
        
       
    }

    public void inserir() {
        daoAnimal.inserir(novoAnimal);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Animal cadastrado", null));
        novoAnimal = new Animal();
        
        
    }

    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }

    public Animal getNovoAnimal() {
        return novoAnimal;
    }

    public void setNovoAnimal(Animal novoAnimal) {
        this.novoAnimal = novoAnimal;
    }
    
    
    
   
    

}