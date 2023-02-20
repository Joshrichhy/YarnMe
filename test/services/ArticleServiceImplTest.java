package services;

import data.models.Article;
import data.models.User;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleServiceImplTest {
    ArticleService  articleService;
    UserRepository userRepository;
    Article newArticle;
    User user;

    @BeforeEach
    void setUp(){
        articleService = new ArticleServiceImpl();
        newArticle = articleService.createPost("Josh new blog", "Having a blog " +
                "is something i have been trying to do with my whole entirety", 1);
    }
    @Test
    public void savePost_postIdIsNotZero(){
        assertTrue(newArticle.getId() != 0);
    }
    @Test
    public void savePost_postIdIsOneTest(){
        assertEquals(1, newArticle.getId());
    }
    @Test
    public void findPostWithId(){
        Article foundArticle = articleService.findPost(1);
        String expected = "Josh new blog";
        assertEquals(expected, foundArticle.getTitle());
    }
    @Test
    public void throwException_findPostWhenIdIsWrong(){
        assertThrows(IllegalArgumentException.class, ()-> articleService.findPost(2));
        }

    @Test
    public void findPostWithAuthoId(){
        assertEquals(1,  newArticle.getAuthorId());
    }

}
