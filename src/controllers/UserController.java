package controllers;

import dtos.requests.RegisterRequest;
import services.UserService;
import services.UserServiceImpl;

public class UserController {
    private UserService userService = new UserServiceImpl();


    public Object register(RegisterRequest request){
        try{
            return userService.register(request);
        }
        catch (IllegalArgumentException ex){
            return ex.getMessage();}
    }

    public Object findUserById(int id) {
        try {
            return userService.findUser(id);
        } catch (NullPointerException ex) {
          return  ex.getMessage();}
    }
}

