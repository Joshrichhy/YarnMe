package controllers;

import data.models.Article;
import data.models.User;
import services.ArticleService;
import services.ArticleServiceImpl;

public class ArticleController {
    private ArticleService articleService = new ArticleServiceImpl();

    public Object createPost(String title, String body, int id){
        try{return articleService.createPost(title, body, id);}
        catch (NullPointerException e){return e.getMessage();}
    }

    public Object findPost(int id){
        try{
      return   articleService.findPost(id);}
        catch (IllegalArgumentException ex){return ex.getMessage();
        }
    }
    public Object findAllPostbyUser(int userId){
        return articleService.findAllPostbyUserId(userId);
    }
    public Object findAllPosts(){
        return articleService.findAllPost();
}
}
