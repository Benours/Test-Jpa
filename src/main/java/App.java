import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    
    private static final Logger LOGGER = LoggerFactory.getLogger( App.class );
    
    public static void main( String[] args ) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory( "digi-d12" );
        EntityManager em = emf.createEntityManager();
        System.out.println(em);
        em.close();
        emf.close();
        LOGGER.info( "Hello, world!!" );
    }
}