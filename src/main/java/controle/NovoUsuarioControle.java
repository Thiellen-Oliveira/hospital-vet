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
/**
 *
 * @author temporario
 */
@Named
@ViewScoped
public class NovoUsuarioControle implements Serializable{
    
    private Usuario usuario;
    Dao dao; 
    
    @PostConstruct
    public void iniciar(){
        usuario = new Usuario(); 
        dao = new Dao(Usuario.class); 
    }
    
    public String gravar(){
       dao.inserir(usuario);
      
//        if ( temp == null ){
//            FacesContext context = FacesContext.getCurrentInstance();
//            context.addMessage(null, new FacesMessage
//            (FacesMessage.SEVERITY_ERROR, "Usuário ou senha inválidos", null)
//            );
//            return null ;
//        }
        return "menu"; 
    }
    public String cancelar()
    {
        dao.inserir(usuario);
        return "menu";
    }
    
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}

