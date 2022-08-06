package de.fherfurt.storage.repository;

import de.fherfurt.model.Comment;
import  de.fherfurt.model.User;
import de.fherfurt.model.Post;

import java.util.ArrayList;
import java.util.List;


class RepositoryImpl implements UserRepository,PostRepository,CommentRepository {

    private final UserDao userDao;
    private final PostDao postDao;
    private final GenericDao<Comment> commentDao;

    RepositoryImpl(UserDao userDao, PostDao postDao, GenericDao<Comment> commentDao){
        this.userDao = userDao;
        this.postDao = postDao;
        this.commentDao = commentDao;
    }

    @Override
    public List<User> getAllUsers(){
        return new ArrayList<>(this.userDao.findAll());
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
    public boolean deleteUser(long userId) {
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
    public boolean createPost(Post post) {
        return false;
    }

    @Override
    public boolean updatePost(Post post) {
        return false;
    }

    @Override
    public boolean deletePost(long postId) {
        return false;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public Comment getComment(long commentId) {
        return null;
    }

    @Override
    public boolean createComment(Comment comment) {
        return false;
    }

    @Override
    public boolean updateComment(Comment comment) {
        return false;
    }

    @Override
    public boolean deleteComment(long commentId) {
        return false;
    }
}
