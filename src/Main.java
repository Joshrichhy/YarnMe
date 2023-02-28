import controllers.ArticleController;
import controllers.UserController;
import data.models.Article;
import dtos.requests.RegisterRequest;

import javax.swing.*;

public class Main {
    private static UserController userController = new UserController();
    private static ArticleController articleController = new ArticleController();
    public static void main(String[] args) {
        startApp();
    }

    private static void startApp() {
        String message = """
                Hi, wetyn you wan like yarn
                1 --> Register
                 2--> Find User
                 3--> Create Post
                 4--> Find Post
                 5 --> Find Posts with User Id
                 6 --> Read All Posts
                 """;
        String input = input(message);
        switch ((input.charAt(0))){
            case '1' -> register();
            case '2' -> findUser();
            case '3' -> createPost();
            case '4' -> findPost();
            case '5' -> findPostWithUserId();
            case '6' -> readAllPosts();
                default ->  {
                    display("Invalid input, try again");
                    startApp();
                }
        }
    }

    private static void readAllPosts() {
        display(articleController.findAllPosts().toString());
        startApp();
    }

    private static void findPostWithUserId() {
        String userInput = input("Enter User ID to find All Posts");
        display(articleController.findAllPostbyUser(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void findPost() {
        String userInput = input("Enter Post ID to search for");
        display(articleController.findPost(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void createPost() {
        String title = input("Write Title");
        String body = input("Write Post");
        int id = Integer.parseInt(input("Enter your user id"));
        var post = articleController.createPost(title, body, id);
        display(post.toString());

        startApp();
        
    }

    private static void findUser() {
        String userInput = input("Enter User ID to search for");
        display(userController.findUserById(Integer.parseInt(userInput)).toString());
        startApp();
    }

    private static void register() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName(input("Enter First Name"));
        request.setLastName(input("Enter Last Name"));
        request.setUserName(input("Enter Username"));
        request.setPassword(input("Enter Password"));
        var result = userController.register(request);
        display(result.toString());
        startApp();

    }
    private static String input(String prompt) {
        return JOptionPane.showInputDialog(prompt);
    }

    private static void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }

}