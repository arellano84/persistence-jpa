package cliente;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import app.modelo.Persona;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Map <String,String>persona = new HashMap<String,String>();
        persona.put("Luis","00000001A");
        persona.put("Juan","00000002B");
        persona.put("Jesus","00000003C");
        persona.put("Beto","00000004D");
        persona.put("Felipe","00000005E");
        persona.put("Pedro","00000006F");
        persona.put("Francisco","00000007G");
        persona.put("Javier","00000008H");
        persona.put("Jose","00000009I");
        persona.put("Ana","00000001J");
        persona.put("Bego","00000002K");
        persona.put("Carolina","00000003L");
        persona.put("Elsa","00000004M");
        persona.put("Soraya","00000005N");
        persona.put("Maria","00000006O");
        persona.put("Almu","00000007P");
        persona.put("Adele","00000008Q");
        persona.put("Gaspar","00000009R");
        persona.put("Raul","00000001S");
        persona.put("Rosa","00000002T");

        try{
	        et.begin();
	        
	        for (Map.Entry<String,String> entry : persona.entrySet()) {
	            em.persist(new Persona( entry.getKey(),entry.getValue()));
	        }
	        et.commit();
	        
	    }catch(Exception ex){
	        et.rollback();
	        ex.printStackTrace();
	    }finally{
	        em.close();
	    }
        
        System.out.println("---------------------------------");
     
        emf = Persistence.createEntityManagerFactory("PURead");
        em = emf.createEntityManager();
        et = em.getTransaction();
        
//        Query consulta = em.createQuery("select p from Persona p order by p.codigo desc");
//        List<Persona> personas = consulta.getResultList();
        Query q1 = em.createNamedQuery("todas");
        List<Persona> personas =  q1.getResultList();
        System.out.println(personas.size() + " persona(s) encontradas.");
        for(Persona p : personas)
            System.out.println(p);
        System.out.println("---------------------------------");

        Query q2 = em.createNamedQuery("ordenadas");
        List<Persona> todas = q2.getResultList();
        System.out.println(todas.size() + " persona(s) ordenadas.");
        for(Persona p : todas)
            System.out.println(p);
        System.out.println("---------------------------------");
        
        
        em.close();
		
	}

}
