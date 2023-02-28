package services;

import data.models.Article;
import java.util.List;

public interface ArticleService {

    Article createPost (String title, String body, int id);
    Article findPost(int id);
    List<Article> findAllPostbyUserId(int userId);
    List<Article> findAllPost();
}
