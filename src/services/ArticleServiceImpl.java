package services;

import data.models.Article;
import data.models.User;
import data.repositories.ArticleRepository;
import data.repositories.ArticleRepositoryImpl;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository = new ArticleRepositoryImpl();
    UserService userService = new UserServiceImpl();
    @Override
    public Article createPost(String title, String body, int id) {
        Article post = new Article();
        User savedUser = userService.findId(id);
         int  identity = savedUser.getId();
            post.setTitle(title);
            post.setBody(body);
            post.setAuthorId(identity);
            return   articleRepository.save(post);
    }

    @Override
    public Article findPost(int id) {
        return articleRepository.findby(id);
    }

    @Override
    public List<Article> findAllPostbyUserId(int userId) {
        return articleRepository.findbyUserId(userId);
    }

    @Override
    public List<Article> findAllPost() {
        return articleRepository.findAll();
    }

}
