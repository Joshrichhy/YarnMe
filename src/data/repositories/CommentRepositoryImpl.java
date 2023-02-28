package data.repositories;

import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImpl implements CommentRepository{


    List <Comment> comments = new ArrayList<>();
    private int count;
    @Override
    public Comment save(Comment comment) {
        boolean commentHasNotBeenSaved = comment.getId() == 0;
        if(commentHasNotBeenSaved){
        comment.setId(generateId());
        comments.add(comment);
        count++;}
        return comment;
    }

    private int generateId() {
        return count +1;
    }

    @Override
    public Comment findby(int id) {
        for (Comment comment: comments) {
            if(comment.getId() == id)
                return comment;
            break;
        }
        return null;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override    
    public void delete(int id) {
        for (Comment comment : comments) {
            if(comment.getId() == id)
              comments.remove(comment);
            count--;
            break;}
    }

    @Override
    public void delete(Comment comment) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return count;
    }
}
