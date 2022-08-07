package de.fherfurt.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class BaseResource
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(@HeaderParam("oid") @DefaultValue("-1") String token)
    {
        return "Hello from Base Resource " + token;
    }

    @Path("/oosers")
    public OosersResource getOsersResource()
    {
        return new OosersResource();
    }

    @Path("/posts")
    public PostsResource getPostsResource()
    {
        return new PostsResource();
    }

    @Path("/comments")
    public CommentsResource getCommentsResource()
    {
        return new CommentsResource();
    }

}