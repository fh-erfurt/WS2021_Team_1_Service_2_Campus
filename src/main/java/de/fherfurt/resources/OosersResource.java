package de.fherfurt.resources;


import de.fherfurt.model.Ooser;
import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.OoserRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;



public class OosersResource {
    private static final Logger LOGGER = Logger.getLogger( OosersResource.class.getSimpleName());

    private final OoserRepository ooserRepository;

    public OosersResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.ooserRepository = RepositoryFactory.getInstance().getOoserRepository();
    }

    @Path("{postId:\\d+}/posts")
    public PostsResource getPostsResource()
    {
        return new PostsResource();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ooser> getOosers(
            @QueryParam("OoserId") @DefaultValue("-1") long OoserId
    ){
        return this.ooserRepository.getAllOosers();
    }

    @GET
    @Path("{OoserId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOoser(@PathParam("OoserId") long ooserId){
        Ooser u = this.ooserRepository.getOoser(ooserId);

        if(u != null)
            return Response.ok(u).build();
        else
            return Response.status( Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOoser(Ooser ooserToCreate){
        boolean success = this.ooserRepository.createOoser(ooserToCreate);

        if(success)
            return Response.ok(ooserToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @DELETE
    @Path("{ooserId:\\d+}")
    public Response deleteOoser(@PathParam("ooserId") long ooserId){
        Ooser u = this.ooserRepository.getOoser( ooserId);

        if(u != null){
            this.ooserRepository.deleteOoser(ooserId);
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("{ooserId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateOoser(Ooser ooserToUpdate){
        boolean success = this.ooserRepository.updateOoser(ooserToUpdate);

        if(success)
            return Response.ok().build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
