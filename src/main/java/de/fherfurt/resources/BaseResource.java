package de.fherfurt.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api")
public class BaseResource{
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String info(){
        return "Info";
    }

    @Path("/users")
    public UserResource getUserResource(){
        return new UserResource();
    }

    @Path("/posts")
    public PostsResource getPostsResource(){
        return new PostsResource();
    }
}