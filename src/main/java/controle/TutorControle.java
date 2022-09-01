package controle;

import dao.Dao;
//import dao.DaoUsuario;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Tutor;


/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class TutorControle implements Serializable{
    
    private Tutor tutor;
    private Tutor tutorAlterar;
    private Dao<Tutor> dao;
    private List<Tutor> listaTutores;
    private boolean mostraPopup; 
    
    @PostConstruct
    public void iniciar() {
        setTutor(new Tutor());
        dao = new Dao(Tutor.class);
        setListaTutores(dao.listarTodos());
        mostraPopup = false; 
    }
    
    public void gravar() {
        dao.inserir(tutor);
        tutor = new Tutor();
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Tutor cadastrado", null)
            );
        listaTutores = dao.listarTodos();
    }
    
//    @PostConstruct
//    public void iniciar(){
//        tutor = new Tutor(); 
//        dao = new Dao(Tutor.class); 
//    }
    
    public void preparaAlterar(Tutor aux){
        System.out.println(aux.getNome());
        tutorAlterar = aux;
        mostraPopup = true; 
    }
    
     public void cancelarAlteracao(){
        mostraPopup = false; 
    }
     
       public void salvarAlteracao(){
        dao.alterar(tutorAlterar);
        FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_INFO, "Tutor alterado", null)
            );
        tutorAlterar = new Tutor();
        listaTutores = dao.listarTodos();
    }
    
     public void excluirTutor(Tutor excluido) {
        dao.excluir(excluido.getId());
        listaTutores = dao.listarTodos();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Tutor> getListaTutores() {
        return listaTutores;
    }

    public void setListaTutores(List<Tutor> listaTutores) {
        this.listaTutores = listaTutores;
    }
    public boolean isMostraPopup() {
        return mostraPopup;
    }

    public void setMostraPopup(boolean mostraPopup) {
        this.mostraPopup = mostraPopup;
    }

    public Tutor getTutorAlterar() {
        return tutorAlterar;
    }

    public void setTutorAlterar(Tutor tutorAlterar) {
        this.tutorAlterar = tutorAlterar;
    }


}