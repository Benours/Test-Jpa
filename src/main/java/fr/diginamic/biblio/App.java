package fr.diginamic.biblio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.biblio.entites.Livre;

public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( App.class );
    
    public static void main( String[] args ) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "digi-d12" );
        EntityManager em = emf.createEntityManager();
        Livre livre1 = em.find(Livre.class, 1);
        Livre livre5 = em.find(Livre.class, 5);
        Livre livre6 = new Livre("L'etranger", "Albert Camus");
        em.getTransaction().begin();
        em.persist(livre6);
        livre5.setTitre("Du plaisir dans la cuisine");
        em.remove(livre6);
        em.getTransaction().commit();
        TypedQuery<Livre> query = em.createQuery("select l from Livre l where l.titre='Germinal'", Livre.class);
        TypedQuery<Livre> query1 = em.createQuery("select l from Livre l where l.auteur='Léon Tolstoï'", Livre.class);
        TypedQuery<Livre> query2 = em.createQuery("select l from Livre l", Livre.class);
        List<Livre> listeLivre = new ArrayList<>();
        listeLivre = query2.getResultList();
        Livre livre2 = query.getResultList().get(0);
        Livre livre3 = query1.getResultList().get(0);
        System.out.println("\n\n");
        System.out.println(livre1);
        System.out.println(livre6);
        System.out.println(livre2);
        System.out.println(livre3);
        System.out.println("\n\n");
        for (Livre livre : listeLivre) {
			System.out.println(livre.toString());
		}
        System.out.println("\n\n");
        em.close();
        emf.close();
    }
}