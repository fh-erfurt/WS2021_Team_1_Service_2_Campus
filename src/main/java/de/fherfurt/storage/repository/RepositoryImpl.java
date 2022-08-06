package de.fherfurt.storage.repository;

import  de.fherfurt.model.User;
import de.fherfurt.model.Category;
import de.fherfurt.model.Post;
import de.fherfurt.model.Comment;
import org.w3c.dom.UserDataHandler;

import java.util.ArrayList;
import java.util.List;


class RepositoryImpl implements UserRepository,PostRepository {

    @Override
    public List<User> getAllUsers(){
        return null;
    }

    @Override
    public User getUser(long userId) {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(Long userId) {
        return false;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public Post getPost(long postId) {
        return null;
    }

    @Override
    public boolean createPost(User user) {
        return false;
    }

    @Override
    public boolean updatePost(long postId) {
        return false;
    }

    @Override
    public boolean deletePost(long postId) {
        return false;
    }
}
