package de.fherfurt.storage.repository;


import de.fherfurt.dataStorage.Post;
import de.fherfurt.dataStorage.User;
import de.fherfurt.util.DataProvide;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.logging.Logger;


public class RepositoryFactory {
    private static final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName());

    private static final String PRODUCTION_PERSISTENCE_UNIT_NAME = "production_socialmedia-unit";
    private static final String DEV_PERSISTENCE_UNIT_NAME = "dev_socialmedia-unit";

    //private final EntityManagerFactory entityManagerFactory;
    //private final RepositoryImpl repository;

    private static RepositoryFactory INSTANCE;

    public static RepositoryFactory getInstance() {
        if( INSTANCE == null )
            INSTANCE = new RepositoryFactory();

        return INSTANCE;
    }


}
