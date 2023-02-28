package data.repositories;

import data.models.Article;
import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository{
    private int count;
    List <Article> Articles = new ArrayList<>();
    @Override
    public Article save(Article post) {
        boolean ArticleNotSaved = post.getId() == 0;
        if(ArticleNotSaved){
        post.setId(generateid());
        Articles.add(post);
        count++;}
        return post;
    }

    private int generateid() {
        return count + 1;
    }

    @Override
    public Article findby(int articleid) {
        for (Article article: Articles) {if (article.getId() == articleid) return article;}
            throw new IllegalArgumentException("Id Not found");
    }

    @Override
    public List<Article> findbyUserId(int userid) {
        ArrayList <Article> userArticles = new ArrayList<>();
        for (Article article: Articles) {if (article.getAuthorId() == userid)userArticles.add(article);}
        return userArticles;
    }

    @Override
    public List<Article> findAll() {
        return Articles;
    }

    @Override
    public void delete(int id) {
        for (Article post : Articles) {
            if(post.getId() == id)Articles.remove(post);
            count--;
            break;}
   }

    @Override
    public void delete(Article article) {
        for (Article post : Articles) {
            if(post == article)Articles.remove(post);
            count--;
            break;
        }
    }

    @Override
    public void deleteAll() {
        Articles.clear();
        count = 0;

    }

    @Override
    public long count() {
        return count;
    }
}
