package de.fherfurt.storage.repository;

import de.fherfurt.model.Comment;
import de.fherfurt.model.Ooser;
import de.fherfurt.model.Post;

import java.util.ArrayList;
import java.util.List;


class RepositoryImpl implements OoserRepository,PostRepository,CommentRepository {

    private final OoserDao ooserDao;
    private final PostDao postDao;
    private final GenericDao<Comment> commentDao;

    RepositoryImpl(OoserDao ooserDao, PostDao postDao, GenericDao<Comment> commentDao){
        this.ooserDao = ooserDao;
        this.postDao = postDao;
        this.commentDao = commentDao;
    }

    @Override
    public List<Ooser> getAllOosers(){
        return new ArrayList<>(this.ooserDao.findAll());
    }

    @Override
    public Ooser getOoser(long ooserId) {
        return this.ooserDao.findById(ooserId);
    }

    @Override
    public boolean createOoser(Ooser ooser) {
        return this.ooserDao.create(ooser);
    }

    @Override
    public boolean updateOoser(Ooser ooser) {
        return this.ooserDao.update(ooser) == ooser;
    }

    @Override
    public boolean deleteOoser(long ooserId) {
        return this.ooserDao.delete(ooserId);
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(this.postDao.findAll());
    }

    @Override
    public Post getPost(long postId) {
        return this.postDao.findById(postId);
    }

    @Override
    public boolean createPost(Post post) {
        return this.postDao.create(post);
    }

    @Override
    public boolean updatePost(Post post) {
        return this.postDao.update(post) == post;
    }

    @Override
    public boolean deletePost(long postId) {
        return this.postDao.delete(postId);
    }

    @Override
    public List<Comment> getAllComments() {
        return new ArrayList<>(this.commentDao.findAll());
    }

    @Override
    public Comment getComment(long commentId) {
        return this.commentDao.findById(commentId);
    }

    @Override
    public boolean createComment(Comment comment) {
        return this.commentDao.create(comment);
    }

    @Override
    public boolean updateComment(Comment comment) {
        return this.commentDao.update(comment) == comment;
    }

    @Override
    public boolean deleteComment(long commentId) {
        return this.commentDao.delete(commentId);
    }
}
