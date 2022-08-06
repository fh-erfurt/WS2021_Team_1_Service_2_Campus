package de.fherfurt.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class BaseResource
{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info()
    {
        return "Hello from Base Resource";
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

}