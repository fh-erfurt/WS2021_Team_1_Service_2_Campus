package de.fherfurt.storage.repository;

import de.fherfurt.model.Comment;
import de.fherfurt.util.DataProvide;

import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class RepositoryFactory {
    private static final Logger LOGGER = Logger.getLogger( RepositoryFactory.class.getSimpleName());

    private static final String PRODUCTION_PERSISTENCE_UNIT_NAME = "production_socialMedia-unit";
    private static final String DEV_PERSISTENCE_UNIT_NAME = "dev_socialMedia-unit";

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
        this.repository = new RepositoryImpl(this.getOoserDao(), this.getPostDao(), this.getCommentDao());

        LOGGER.info("Create Test Data");
        DataProvide.createTestData().forEach(this.repository::createOoser);


    }

    private EntityManagerFactory prepareEntityManagerFactory()
    {
        LOGGER.info( "Prepare Entity Manager Factory");

        String runMode = System.getenv("RUN_MODE");
        LOGGER.info( "RUN_MODE: " +  runMode );

        if(runMode != null && runMode.equalsIgnoreCase( "production" ) )
            return Persistence.createEntityManagerFactory( PRODUCTION_PERSISTENCE_UNIT_NAME );
        else
            return Persistence.createEntityManagerFactory( DEV_PERSISTENCE_UNIT_NAME );
    }

    public OoserRepository getOoserRepository()
    {
        return this.repository;
    }

    public PostRepository getPostRepository()
    {
        return this.repository;
    }

    public CommentRepository getCommentRepository()
    {
        return this.repository;
    }

    private OoserDao getOoserDao()
    {
        return new JpaOoserDao(this.entityManagerFactory.createEntityManager());
    }
    private PostDao getPostDao()
    {
        return new JpaPostDao(this.entityManagerFactory.createEntityManager());
    }
    private GenericDao<Comment> getCommentDao()
    {
        return  new JpaGenericDao<>(Comment.class, this.entityManagerFactory.createEntityManager());
    }
}
