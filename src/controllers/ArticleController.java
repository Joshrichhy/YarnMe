package controllers;

import data.models.Article;
import data.models.User;
import services.ArticleService;
import services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(String title, String body, int id){
        return articleService.createPost(title, body, id);
    }

    public Object findPost(int id){
        try{
      return   articleService.findPost(id);}
        catch (IllegalArgumentException ex){return ex.getMessage();
        }
    }
}
