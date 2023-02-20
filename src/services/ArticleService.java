package services;

import data.models.Article;

public interface ArticleService {

    Article createPost (String title, String body, int id);
    Article findPost(int id);
}
