package de.fherfurt.resources;


import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.UsersRepository;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;



public class UsersResource {
    private static final Logger LOGGER = Logger.getLogger( UsersResource.class.getSimpleName());

    private final UsersRepository usersRepository;

    public UsersResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));
        this.addressRepository = RepositoryFactory.
    }
}
