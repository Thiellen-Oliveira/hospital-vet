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

    private Animal novoAnimal;
    private Animal animalAlterar;
    private Dao<Tutor> dao;
    private Dao<Animal> daoAnimal;
    private List<Tutor> listaTutores;
    private List<Animal> listaAnimais;

    public List<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public void setListaAnimais(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }
    
    
    private boolean mostraPopup; 
    
    
    

    @PostConstruct
    public void iniciar() {
        dao= new Dao(Tutor.class);
        daoAnimal = new Dao(Animal.class);
        setListaTutores(dao.listarTodos());
        setListaAnimais(daoAnimal.listarTodos());
        setNovoAnimal(new Animal());
        mostraPopup = false; 
        
       
    }
    

    public void inserir() {
//        novoAnimal.getTutor().getAnimais().add(novoAnimal);
        daoAnimal.inserir(novoAnimal);
        novoAnimal = new Animal();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Animal cadastrado", null));
        listaAnimais = daoAnimal.listarTodos();
        
        
    }
    
     public void preparaAlterar(Animal aux){
        animalAlterar = aux;
        mostraPopup = true; 
     }
     public void cancelarAlteracao(){
        mostraPopup = false; 
    }
     
      public void salvarAlteracao(){
        daoAnimal.alterar(animalAlterar);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Animal alterado", null)
            );
        animalAlterar = new Animal();
        listaAnimais = daoAnimal.listarTodos();
    }
      
      public void excluirAnimal(Animal excluido) {
        daoAnimal.excluir(excluido.getId());
        listaAnimais = daoAnimal.listarTodos();
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
    
    public boolean isMostraPopup() {
        return mostraPopup;
    }

    public void setMostraPopup(boolean mostraPopup) {
        this.mostraPopup = mostraPopup;
    }

    public Animal getAnimalAlterar() {
        return animalAlterar;
    }

    public void setAnimalAlterar(Animal animalAlterar) {
        this.animalAlterar = animalAlterar;
    }
    
    
    
   
    

}