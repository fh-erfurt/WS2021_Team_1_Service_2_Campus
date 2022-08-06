package de.fherfurt.storage.repository;

import de.fherfurt.model.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getAllPosts();

    Post getPost(long postId);
    boolean createPost(Post post);
    boolean updatePost(Post post);
    boolean deletePost(long postId);

}
