package de.fherfurt.resources;


import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.UserRepository;
import de.fherfurt.model.User;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.annotation.PreDestroy;
import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.logging.Logger;



public class UsersResource {
    private static final Logger LOGGER = Logger.getLogger( UsersResource.class.getSimpleName());

    private final UserRepository userRepository;

    public UsersResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.userRepository = RepositoryFactory.getInstance().getUserRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(
            @QueryParam("userId") @DefaultValue("-1") long userId
    ){
        return this.userRepository.getAllUsers();
    }

    @GET
    @Path("{userId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("userId") long userId){
        User u = this.userRepository.getUser(userId);

        if(u != null)
            return Response.ok(u).build();
        else
            return Response.status( Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User userToCreate){
        boolean success = this.userRepository.createUser(userToCreate);

        if(success)
            return Response.ok(userToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @DELETE
    @Path("{userId:\\d+}")
    public Response deleteUser(@PathParam("userId") long userId){
        User u = this.userRepository.getUser( userId);

        if(u != null){
            this.userRepository.deleteUser(userId);
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
