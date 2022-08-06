package de.fherfurt.resources;

import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.CommentRepository;
import de.fherfurt.model.Post;
import de.fherfurt.model.Comment;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.internal.util.PropertiesClass;

import java.util.List;
import java.util.logging.Logger;

public class CommentsResource {
    private static final Logger LOGGER = Logger.getLogger( UsersResource.class.getSimpleName());

    private final CommentRepository commentsRepository;

    public CommentsResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.commentsRepository = RepositoryFactory.getInstance().getCommentRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getComments(
            @QueryParam("commentId") @DefaultValue("-1") long commentId
    ){
        return this.commentsRepository.getAllComments();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComment(Comment commentToCreate){
        boolean success = this.commentsRepository.createComment(commentToCreate);

        if(success)
            return Response.ok(commentToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
