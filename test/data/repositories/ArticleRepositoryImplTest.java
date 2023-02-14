package data.repositories;

import data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {

    ArticleRepository articleRepository;
    Article article;

    @BeforeEach
    void setUp(){
    articleRepository = new ArticleRepositoryImpl();
    article = new Article();
}
    @Test
    void saveOneArticle_CountIsOne(){


    articleRepository.save(article);
    assertEquals(1, articleRepository.count());
    }
    @Test
    void saveOneArticle_ArticleIdIsOne(){
        Article saveArticle = articleRepository.save(article);
        assertEquals(1, saveArticle.getId());
    }

    @Test
    public void savePostAndPostIdDidNotChange() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        savedArticle.setTitle("I am tired of this country");
        articleRepository.save(savedArticle);
        assertEquals(1, articleRepository.count());
    }
    @Test
    public void saveArticleTwice_ArticleisStillOne() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundArticle= articleRepository.findby(1);
        assertEquals(foundArticle, savedArticle);
    }
    @Test
    public void savePostAndGetPostWithId() {
        Article savedPost = articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        Article findPost = articleRepository.findby(1);
        assertEquals(findPost, savedPost);
    }

    @Test
    public void saveOnePostAndDeletePostWithId() {
         articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.count() );
    }
    @Test
    public void saveOnePostAndDeleteOnePostWithId() {
        articleRepository.save(article);
        assertEquals(1, articleRepository.count());
        articleRepository.delete(article);
        assertEquals(0, articleRepository.count() );
    }
    @Test
    public void saveTwoPostAndDeleteOnePostWithId() {
        Article article2 = new Article();
        articleRepository.save(article);
        articleRepository.save(article2);
        assertEquals(2, articleRepository.count());
        articleRepository.delete(article);
        assertEquals(2, article2.getId() );
    }
    @Test
    public void saveTwoPostAndDeletAllPost() {
        Article article2 = new Article();
        articleRepository.save(article);
        articleRepository.save(article2);
        assertEquals(2, articleRepository.count());
        articleRepository.deleteAll();
        assertEquals(0, articleRepository.count());
    }

    @Test
    public void saveTwoPostAndFindAllPost() {
        Article article2 = new Article();
        articleRepository.save(article);
        articleRepository.save(article2);
        assertEquals(2, articleRepository.count());
        System.out.println(articleRepository.findAll().toString());

    }
}