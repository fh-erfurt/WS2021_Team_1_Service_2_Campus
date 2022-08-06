package de.fherfurt.resources;

import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.PostRepository;
import de.fherfurt.model.Post;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.print.attribute.standard.Media;
import java.util.logging.Logger;
import java.util.List;

public class PostsResource {
    private static final Logger LOGGER = Logger.getLogger(PostsResource.class.getSimpleName());

    private final PostRepository postsRepository;

    public PostsResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.postsRepository = RepositoryFactory.getInstance().getPostRepository();
    }

    @Path("{postId:\\d+}/comment")
    public CommentsResource getCommentsResource()
    {
        return new CommentsResource();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts(
            @QueryParam("postId")@DefaultValue("-1") long postId
    ){
        return this.postsRepository.getAllPosts();
    }

    @GET
    @Path("{PostId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPost(@PathParam("PostId") long postId){
        Post p = this.postsRepository.getPost(postId);

        if(p != null)
            return Response.ok(p).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPost(Post postToCreate){
        boolean success = this.postsRepository.createPost(postToCreate);

        if(success)
            return Response.ok(postToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

}
