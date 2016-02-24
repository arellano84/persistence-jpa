package cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import app.modelo.Camion;
import app.modelo.Coche;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Camion v1 = new Camion("Modelo3",50,60,70,80);
        Coche v2 = new Coche("Modelo4",50,60,70,80);
        
        try{
            et.begin();
            
            em.persist(v1);
            em.persist(v2);

            et.commit();
            
            System.out.println(v1);
            System.out.println(v2);
            
        }catch(Exception ex){
            et.rollback();
            ex.printStackTrace();
        }finally{
            em.close();
        }
        
	}

}
