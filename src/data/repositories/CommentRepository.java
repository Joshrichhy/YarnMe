package data.repositories;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment save (Comment comment);
    Comment findby(int id);
    List <Comment> findAll();
    void delete(int id);
    void delete(Comment comment);
    void deleteAll();
    long count();

}
