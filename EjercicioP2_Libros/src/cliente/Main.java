package cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import app.modelo.Libro;
import app.modelo.LibroPK;


public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        try{
	        et.begin();
            
	        em.persist(new Libro("Hibernate","James","Hibernate en 20 dias","..."));
	        em.persist(new Libro("Spring","Joan","Spring en 20 dias","..."));
	        em.persist(new Libro("Struts","Andy","Struts en 20 dias","..."));
	        em.persist(new Libro("JSF","Joe","JSF en 20 dias","..."));
	        em.persist(new Libro("HTML5","Julie","HTML5 en 20 dias","..."));
	        
            et.commit();
	        
	    }catch(Exception ex){
	        et.rollback();
	        ex.printStackTrace();
	    }finally{
	        em.close();
	    }
        
        
        emf = Persistence.createEntityManagerFactory("PURead");
        em = emf.createEntityManager();
        et = em.getTransaction();
        
        
        System.out.println("Consultando todos...---------------------------------");
        Query consulta = em.createQuery("select l from Libro l order by l.titulo asc");
        List<Libro> lresultado = consulta.getResultList();
        System.out.println(lresultado.size() + " libros(s) ordenadas.");
        for(Libro l : lresultado)
        	System.out.println(l);
        
        
        System.out.println("Consultando Julie...---------------------------------");
        Query q2 = em.createNamedQuery("autores");
        q2.setParameter("autor", "Julie");
        List<Libro> lresultado2 = q2.getResultList();
        for(Libro l: lresultado2)
        	System.out.println(l);
        
        
        System.out.println("Eliminando Spring...---------------------------------");
//      Query q2 = em.createQuery("delete from Libro p where p.libroPk.titulo = :title");
//      q2.setParameter("title", "El tiempo entre costuras");
//      tx.begin();
//      q2.executeUpdate();
//      tx.commit();
        Libro p2 = em.find(Libro.class, new LibroPK("Spring", "Joan"));
        em.getTransaction().begin();
        em.remove(p2);
        em.getTransaction().commit();
        
        List<Libro> lresultado4 = consulta.getResultList();
        for(Libro l: lresultado4)
        	System.out.println(l);
        
        
        System.out.println("Modificando James...---------------------------------");
//      Query q3 = em.createQuery("update Libro p SET p.descripcion = :desc WHERE p.libroPk.titulo = :title");
//      q3.setParameter("desc", "Nueva descripcion");
//      q3.setParameter("title", "Los pilares de la tierra");
//      tx.begin();
//      q3.executeUpdate();
//      tx.commit();
        LibroPK pk = new LibroPK("Hibernate", "James");
        Libro p1 = em.find(Libro.class, pk);
        em.getTransaction().begin();
        p1.setDescripcion("En realidad en 6 meses.");
        em.getTransaction().commit();
        
        Query q3 = em.createNamedQuery("autores");
        q3.setParameter("autor", "James");
        List<Libro> lresultado3 = q3.getResultList();
        for(Libro l: lresultado3)
        	System.out.println(l);
        
        
        em.close();
	}

}
