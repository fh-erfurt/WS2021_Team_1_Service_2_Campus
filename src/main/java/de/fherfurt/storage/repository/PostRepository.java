package de.fherfurt.storage.repository;

import de.fherfurt.model.Post;
import de.fherfurt.model.User;

import java.util.List;

public interface PostRepository {

    List<Post> getAllPosts();

    Post getPost(long postId);
    boolean createPost(User user);
    boolean updatePost(long postId);
    boolean deletePost(long postId);

}
