package controle;

import dao.Dao;
import dao.DaoUsuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.Usuario;

@Named
@ViewScoped
public class IndexControle implements Serializable {
    private Usuario usuario;
    DaoUsuario dao; 
    
    @PostConstruct
    public void iniciar(){
        usuario = new Usuario(); 
        dao = new DaoUsuario(); 
    }
    
    public String autenticar(){
        Usuario temp = dao.autenticar(usuario); 
        if ( temp == null ){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage
            (FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null)
            );
            return null ;
        }
        return "menu"; 
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}