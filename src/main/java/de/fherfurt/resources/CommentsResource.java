package de.fherfurt.resources;

import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.CommentRepository;
import de.fherfurt.model.Comment;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.logging.Logger;

public class CommentsResource {
    private static final Logger LOGGER = Logger.getLogger( OosersResource.class.getSimpleName());

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

}
