package cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.modelo.Escuderia;
import app.modelo.Facturacion;
import app.modelo.Nif;
import app.modelo.Piloto;
import app.modelo.Telefono;
import app.modelo.Temporada;

public class Main {

	public static void main(String[] args) {
		 // 1.- Crear EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

        // 2.- Crear EntityManager
        EntityManager em = emf.createEntityManager();

        // 3.- Obtener una tx
        EntityTransaction et = em.getTransaction();
        
        
        //Iniciando...
        
        
        
        Nif n1 = new Nif('A', 12345678L);
        Telefono t1 = new Telefono(656111111L);
        Facturacion f1 = new Facturacion(32000,1000);
        
        Piloto p1 = new Piloto("Luis", 12, f1, n1);
        p1.addTelefono(t1);
        
        Escuderia e1 = new Escuderia("Ferrari", "Italia");
        e1.addPilotos(p1);
        
        Temporada temp1 = new Temporada(2012, 2013);
        p1.addTemporada(temp1);
        
        try{
            et.begin();
            
            em.persist(e1);

            em.persist(p1);

            et.commit();
            
            System.out.println(p1);
            
        }catch(Exception ex){
            et.rollback();
            ex.printStackTrace();
        }finally{
            em.close();
        }
	}
}
