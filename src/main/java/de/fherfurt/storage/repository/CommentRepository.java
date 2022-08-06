package de.fherfurt.storage.repository;

import de.fherfurt.model.Comment;

import java.util.List;

public interface CommentRepository {

    List<Comment> getAllComments();

    Comment getComment(long commentId);
    boolean createComment(Comment comment);
    boolean updateComment(Comment comment);
    boolean deleteComment(long commentId);

}
