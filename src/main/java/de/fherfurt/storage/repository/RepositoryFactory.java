package de.fherfurt.storage.repository;

import de.fherfurt.model.User;
import de.fherfurt.util.DataProvide;

import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;


public class RepositoryFactory {
    private static final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName());

    private static final String PRODUCTION_PERSISTENCE_UNIT_NAME = "production_socialmedia-unit";
    private static final String DEV_PERSISTENCE_UNIT_NAME = "dev_socialmedia-unit";

    private final EntityManagerFactory entityManagerFactory;
    private final RepositoryImpl repository;

    private static RepositoryFactory INSTANCE;

    public static RepositoryFactory getInstance() {
        if( INSTANCE == null )
            INSTANCE = new RepositoryFactory();

        return INSTANCE;
    }

    private RepositoryFactory()
    {
        LOGGER.info("Init Repo Factory");

        this.entityManagerFactory = prepareEntityManagerFactory();

        LOGGER.info("Create RepositoryImpl");
        this.repository = new RepositoryImpl();

        LOGGER.info("Create Test Data");
        DataProvide.createTestData().forEach(this.repository::createUser);

    }

    private EntityManagerFactory prepareEntityManagerFactory()
    {
        LOGGER.info( "Prepare Entity Manager Factory");

        String runMode = System.getenv("RUN_MODE");
        LOGGER.info( "RUN_MODE: " +  runMode );

        if( runMode.equalsIgnoreCase( "production" ) )
            return Persistence.createEntityManagerFactory( PRODUCTION_PERSISTENCE_UNIT_NAME );
        else
            return Persistence.createEntityManagerFactory( DEV_PERSISTENCE_UNIT_NAME );
    }

    public UserRepository getUserRepository()
    {
        return this.repository;
    }

    public PostRepository getPostRepository()
    {
        return this.repository;
    }
}
