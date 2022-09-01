package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Animal;
import util.JpaUtil;

public class DaoAnimal implements Serializable {
    
    public List<Animal> buscarPorTutor(Integer idTutor){
        EntityManager manager = JpaUtil.getEntityManager();
        TypedQuery<Animal> query = 
                (TypedQuery<Animal>) manager.createQuery("SELECT a FROM Animal a WHERE a.tutor.id = :idTutor ");
        query.setParameter("idTutor", idTutor);
        List<Animal> lista = query.getResultList();
        manager.close();        
        return lista; 
    }
}