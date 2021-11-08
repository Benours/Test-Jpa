package fr.diginamic.banque;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.diginamic.banque.entites.Adresse;
import fr.diginamic.banque.entites.AssuranceVie;
import fr.diginamic.banque.entites.Banque;
import fr.diginamic.banque.entites.ClientBanque;
import fr.diginamic.banque.entites.Compte;
import fr.diginamic.banque.entites.LivretA;
import fr.diginamic.banque.entites.Operation;
import fr.diginamic.banque.entites.Virement;

public class TestBanque {

private static final Logger LOGGER = LoggerFactory.getLogger( TestBanque.class );
    
    public static void main( String[] args ) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "banque" );
        EntityManager em = emf.createEntityManager();
        
        Adresse maison = new Adresse(16, "rue des cachous", 34070, "Montpellier");
        Timestamp dateNaissance = new Timestamp(1997, 7, 7, 0, 0, 0, 0);
        Timestamp date = new Timestamp(0);
        ClientBanque client = new ClientBanque("Baska", "Benjamin", dateNaissance, maison);
        Compte compte = new Compte("FR30 XXXX", 500);
//        LivretA livretA = new LivretA("FR30 XXXX XXXX XXXX XX", 253.5, 5.0);
//        AssuranceVie assuranceVie = new AssuranceVie("FR30 XXXX XXXX XXXX XX", 300, date, 2.4);
//        Operation virement = new Virement(date, 30, "Anniversaire", "Benjamin");
        Operation operation = new Operation(date, 30, "Anniversaire");
        Banque banque = new Banque("LCL");
        Set<ClientBanque> clients = new HashSet<>();
        Set<Operation> operations = new HashSet<>();
        em.getTransaction().begin();
        em.persist(banque);
        em.persist(compte);
        banque.setClients(clients);
        banque.addClient(client);
        compte.setOperations(operations);
        compte.addOperation(operation);       
//        em.persist(livretA);
//        em.persist(assuranceVie);
//        Set<Operation> operations = new HashSet<>();
//        Set<Operation> virements = new HashSet<>();
//        operation.setCompte(livretA);
//        virement.setCompte(assuranceVie);
//        virements.add(virement);
//        operations.add(operation);
//        livretA.setOperations(operations);
//        assuranceVie.setOperations(virements);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
