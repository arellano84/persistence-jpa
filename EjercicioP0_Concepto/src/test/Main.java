package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // 1.- EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("PU");

        // 2.- EntityManager es el eje central de JPA
        EntityManager em = emf.createEntityManager();

        // 3.- Obtener una transaccion
        EntityTransaction et = em.getTransaction();

        // 4.- Crear instancias de Test
        Test t1 = new Test(1L,"V5","Test de Idoneidad Versión 5",new Pregunta("1","Pregunta 1"),true);
        Test t2 = new Test(2L,"V6","Test de Idoneidad y Conveniencia Versión 6",new Pregunta("2","Pregunta 2"),true);
        Test t3 = new Test(3L,"V8","Test de Idoneidad y Conveniencia Versión 8",new Pregunta("3","Pregunta 3"),true);

        try{
            et.begin();

            em.persist(t1);
            em.persist(t2);
            em.persist(t3);

            et.commit();

        }catch(Exception ex){
            et.rollback();
            ex.printStackTrace();
        }finally{
            em.close();
        }
        
        
        // 2.- EntityManager es el eje central de JPA
        em = emf.createEntityManager();

        // 3.- Obtener una transaccion
        et = em.getTransaction();
        
        // 2.- Lectura por JPQL
        Query q1 = em.createQuery("select p from Test p where p.version='V5'");
        List<Test> version5 =  q1.getResultList();
        for(Test t : version5)
            System.out.println(t);
        System.out.println("---------------------------------");

        // 3.- Lecturas por NamedQuery
        Query q2 = em.createNamedQuery("todas");
        List<Test> todas = q2.getResultList();
        for(Test t : todas)
            System.out.println(t);
        System.out.println("---------------------------------");

        Query q3 = em.createNamedQuery("version");
        q3.setParameter("ver", "V8");
        Test version8 = (Test) q3.getSingleResult();
        System.out.println(version8);
        System.out.println("---------------------------------");
        
        em.close();
        
	}

}
