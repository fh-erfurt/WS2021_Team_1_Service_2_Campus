package de.fherfurt.resources;

import de.fherfurt.model.Ooser;
import de.fherfurt.storage.repository.OoserRepository;
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
    private final OoserRepository ooserRepository;

    public PostsResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.ooserRepository = RepositoryFactory.getInstance().getOoserRepository();
        this.postsRepository = RepositoryFactory.getInstance().getPostRepository();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts(
            @QueryParam("postId")@DefaultValue("-1") long postId
    ){
        return this.postsRepository.getAllPosts();
    }

}
