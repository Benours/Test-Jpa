package fr.diginamic.banque;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.ClientBanque;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.Operation;

public class TestBanque {

private static final Logger LOGGER = LoggerFactory.getLogger( TestBanque.class );
    
    public static void main( String[] args ) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "banque" );
        EntityManager em = emf.createEntityManager();
        Adresse maison = new Adresse(16, "rue des cachous", 34070, "Montpellier");
        Timestamp dateNaissance = new Timestamp(1997, 7, 7, 0, 0, 0, 0);
        Timestamp date = new Timestamp(0);
        ClientBanque client = new ClientBanque("Baska", "Benjamin", dateNaissance, maison);
        Compte compte = new Compte("FR30 XXXX XXXX XXXX XX", 253.5);
        Operation operation = new Operation(date, 30, "Anniversaire");
        Banque banque = new Banque("LCL");
        em.getTransaction().begin();
        em.persist(banque);
        em.persist(operation);
        em.persist(compte);
        em.persist(client);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
