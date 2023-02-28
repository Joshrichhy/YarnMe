package data.repositories;

import data.models.Article;
import data.models.Comment;

import java.util.List;

public interface ArticleRepository {
    Article save (Article post);
    Article findby(int articleid);
    List<Article> findbyUserId(int userid);
    List<Article> findAll();
    void delete(int id);
    void delete(Article article);
    void deleteAll();
    long count();
}
