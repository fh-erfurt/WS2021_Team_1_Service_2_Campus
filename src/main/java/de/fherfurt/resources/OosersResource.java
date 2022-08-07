package de.fherfurt.resources;


import de.fherfurt.model.Ooser;
import de.fherfurt.model.Post;
import de.fherfurt.model.Comment;
import de.fherfurt.storage.repository.CommentRepository;
import de.fherfurt.storage.repository.PostRepository;
import de.fherfurt.storage.repository.RepositoryFactory;
import de.fherfurt.storage.repository.OoserRepository;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class OosersResource {
    private static final Logger LOGGER = Logger.getLogger( OosersResource.class.getSimpleName());

    private final OoserRepository ooserRepository;
    private final PostRepository postsRepository;
    private final CommentRepository commentsRepository;

    public OosersResource(){
        LOGGER.info("Instance: " + System.identityHashCode( this ));

        this.ooserRepository = RepositoryFactory.getInstance().getOoserRepository();
        this.postsRepository = RepositoryFactory.getInstance().getPostRepository();
        this.commentsRepository = RepositoryFactory.getInstance().getCommentRepository();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ooser> getOosers(
            @QueryParam("ooserId") @DefaultValue("-1") long OoserId
    ){
        return this.ooserRepository.getAllOosers();
    }

    @GET
    @Path("{ooserId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOoser(@PathParam("ooserId") long ooserId){
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
    public Response updateOoser(@PathParam("ooserId") long ooserId, Ooser ooserToUpdate){

        Ooser oldO = this.ooserRepository.getOoser(ooserId);

        boolean oExists = (oldO != null);
        if(!oExists) return Response.status(Response.Status.NOT_FOUND).build();

        ooserToUpdate = updateOoser(oldO, ooserToUpdate);

        boolean success = this.ooserRepository.updateOoser(ooserToUpdate);

        if(success)
            return Response.ok().build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    private Ooser updateOoser(Ooser old, Ooser update){

        if(update.getOoserName() != null)
        {
            old.setOoserName(update.getOoserName());
        }

        if(update.getFullName() != null)
        {
            old.setFullName(update.getFullName());
        }

        return old;
    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //POSTS
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    @GET
    @Path("{ooserId:\\d+}/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAllOoserPosts(@PathParam("ooserId") long ooserId)
    {
        List<Post> ooserPosts = new ArrayList<>();

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return ooserPosts;



        for(Post p:this.postsRepository.getAllPosts()){
            if(p.getPoster() == o) ooserPosts.add(p);
        }
        return ooserPosts;
    }


    @GET
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPost(@PathParam("postId") long postId, @PathParam("ooserId") long ooserId){

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        Post p = this.postsRepository.getPost(postId);

        if(p != null)
            return Response.ok(p).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Path("{ooserId:\\d+}/posts")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPost(@PathParam("ooserId") long ooserId, Post postToCreate){

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        postToCreate.setPoster(o);

        boolean success = this.postsRepository.createPost(postToCreate);

        if(success)
            return Response.ok(postToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @DELETE
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}")
    public Response deletePost(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId)
    {

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        Post p = this.postsRepository.getPost(postId);
        if(p == null) return Response.status(Response.Status.NOT_FOUND).build();

        this.postsRepository.deletePost(p.getId());
        return Response.ok().build();

    }

    @PUT
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePost(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId, Post postToUpdate)
    {
        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        Post oldP = this.postsRepository.getPost(postId);
        if(oldP == null) return Response.status(Response.Status.NOT_FOUND).build();

        postToUpdate = updatePost(oldP, postToUpdate);

        boolean success = this.postsRepository.updatePost(postToUpdate);

        if(success)
            return Response.ok().build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }

    private Post updatePost(Post old, Post update)
    {
        if(update.getTitle() != null)
        {
            old.setTitle(update.getTitle());
        }
        if(update.getText() != null)
        {
            old.setText(update.getText());
        }
        if(update.getLikes() > 0)
        {
            old.setLikes(update.getLikes());
        }

        return old;
    }

    /*
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    Comments
    !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    @POST
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}/comments")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createComments(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId, Comment commentToCreate){

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();
        Post p = this.postsRepository.getPost(postId);
        if(p == null) return Response.status(Response.Status.NOT_FOUND).build();

        commentToCreate.setOoser(o);
        commentToCreate.setPost(p);

        boolean success = this.commentsRepository.createComment(commentToCreate);

        if(success)
            return Response.ok(commentToCreate).build();
        else
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }

    @GET
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllCommentsFromPost(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId)
    {
        List<Comment> postComments = new ArrayList<>();

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return postComments;
        Post p = this.postsRepository.getPost(postId);
        if(p == null) return postComments;

        for(Comment c:this.commentsRepository.getAllComments()){
            if(c.getPost() == p) postComments.add(c);
        }
        return postComments;
    }

    @GET
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}/comments/{commentId:\\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommentFromPost(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId, @PathParam("commentId") long commentId)
    {


        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();
        Post p = this.postsRepository.getPost(postId);
        if(p == null) return Response.status(Response.Status.NOT_FOUND).build();

        if(this.commentsRepository.getComment(commentId) != null)
            return Response.ok(this.commentsRepository.getComment(commentId)).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("{ooserId:\\d+}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getCommentsFromOoser(@PathParam("ooserId") long ooserId)
    {
        List<Comment> ooserComments = new ArrayList<>();

        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return ooserComments;

        for(Comment c:this.commentsRepository.getAllComments()){
            if(c.getOoser() == o) ooserComments.add(c);
        }
        return ooserComments;
    }

    @DELETE
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}/comments/{commentId:\\d+}")
    public Response deleteComment(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId, @PathParam("commentId") long commentId)
    {
        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        Post p = this.postsRepository.getPost(postId);
        if(p == null) return Response.status(Response.Status.NOT_FOUND).build();

        Comment c = this.commentsRepository.getComment(commentId);
        if(c == null) return Response.status(Response.Status.NOT_FOUND).build();

        this.commentsRepository.deleteComment(c.getId());
        return Response.ok().build();
    }

    @PUT
    @Path("{ooserId:\\d+}/posts/{postId:\\d+}/comments/{commentId:\\d+}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteComment(@PathParam("ooserId") long ooserId, @PathParam("postId") long postId, @PathParam("commentId") long commentId, Comment commentToUpdate,
                                  @HeaderParam("oid") @DefaultValue("-1") String oid)
    {
        Ooser o = this.ooserRepository.getOoser(ooserId);
        if(o == null) return Response.status(Response.Status.NOT_FOUND).build();

        Post p = this.postsRepository.getPost(postId);
        if(p == null) return Response.status(Response.Status.NOT_FOUND).build();

        Comment c = this.commentsRepository.getComment(commentId);
        if(c == null) return Response.status(Response.Status.NOT_FOUND).build();

        if(c.getOoser() != this.ooserRepository.getOoser(Long.valueOf(oid))){
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        commentToUpdate = updateComment(c, commentToUpdate);

        return Response.ok().build();
    }

    private Comment updateComment(Comment old, Comment update){
        if(update.getText() != null)
        {
            old.setText(update.getText());
        }
        if(update.getLikes() > 0)
        {
            old.setLikes(update.getLikes());
        }
        return old;
    }

}
