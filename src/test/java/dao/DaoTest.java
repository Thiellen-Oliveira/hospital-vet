/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Animal;
import modelo.Consulta;
import modelo.Tutor;
import modelo.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author temporario
 */
public class DaoTest {
    
    public DaoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

//    @Test
//    public void testInserirUsuario() {
//        Usuario u = new Usuario();
//        u.setLogin("jose");
//        u.setNome("José");
//        u.setSenha("123");
//        Dao<Usuario> dao = new Dao(Usuario.class);
//        dao.inserir(u);
//    }
    
//    @Test
//    public void testInserirTutor() {
//          Tutor t = new Tutor ();
//        
//        t.setNome("Zezinho");
//        t.setCpf("000.000.000-00");
//        t.setEndereco("Avenina Bandeirantes, 00 - Bandeirantes");
//        t.setTelefone("000000000");
//        Dao<Tutor> dao = new Dao(Tutor.class);
//        dao.inserir(t);
//    }
    
//    @Test
//    public void testInserirAnimal() {
//          Animal a = new Animal ();
//        
//        a.setEspecie("Cachorro");
//        a.setRaca("Vira-Lata");
//        a.setNome("Renato");
//        a.setIdade(2);
//        Dao<Tutor> daoTutor = new Dao(Tutor.class);
//        Tutor t = daoTutor.buscarPorId(1);
//        a.setTutor(t);
//        
//        Dao<Animal> dao = new Dao(Animal.class);
//        dao.inserir(a);
//    }
    
//    @Test
//    public void testListarTutor() {
//        Dao<Tutor> daoTutor = new Dao(Tutor.class);
//        List<Tutor> lista = daoTutor.listarTodos();
//        System.out.println("\n\n\n");
//        
//        for (Tutor t : lista){
//            System.out.println(t.getNome());
//            for (Animal a : t.getAnimais()){
//                System.out.println("    " + a.getNome());
//            }
//        }
//    }
    
////    @Test
////    public void testInserirConculta() {
////    Dao<Animal> daoAnimal = new Dao(Animal.class);
////    Animal a = daoAnimal.buscarPorId(5);
////    Consulta c = new Consulta();
////    Dao<Consulta> daoConsulta = new Dao(Consulta.class);
////    c.setAnimal(a);
////    c.setDate(new java.util.Date());
////    c.setDetalhes("teste");
////    daoConsulta.inserir(c);
//    
//    
//    
//    
//    }
}
