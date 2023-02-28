package data.repositories;

import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplTest {
    private CommentRepository commentRepository;
    Comment comment;
    @BeforeEach
    public void setUp() {
        commentRepository = new CommentRepositoryImpl();
        comment = new Comment();
        comment.setComment("I am done with this country");
    }
    @Test
    public void saveCommentAndCommentIsOne(){
        commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
    }

    @Test
    public void saveCommentAndCommentIdisOne(){
        commentRepository.save(comment);
        assertEquals(1, comment.getId());
    }
    @Test
    public void saveCommentAndCommentIdDidNotChange() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        savedComment.setComment("I am tired of this country");
        commentRepository.save(savedComment);
        assertEquals(1, commentRepository.count());
    }
    @Test
    public void saveCommentAndGetById() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, savedComment.getId());
        Comment foundComment= commentRepository.findby(1);
        assertEquals(foundComment, savedComment);
    }
    @Test
    public void saveCommentAndGetCommentWithId() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        Comment findComment = commentRepository.findby(1);
        assertEquals(findComment, savedComment);
    }

    @Test
    public void saveOneCommentAndDeleteCommentWithId() {
        Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count() );
    }
    @Test
    public void saveTwoCommentAndDeleteOneCommentWithId() {
         Comment savedComment = commentRepository.save(comment);
        assertEquals(1, commentRepository.count());
        commentRepository.delete(1);
        assertEquals(0, commentRepository.count() );
    }








}