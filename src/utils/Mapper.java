package utils;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.time.format.DateTimeFormatter;

public class Mapper {
    public static User map(RegisterRequest registerRequest){
        User user = new User();
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
        return user;
    }
    public static void map(RegisterRequest registerRequest, User user){
        user.setUserName(registerRequest.getUserName());
        user.setPassword(registerRequest.getPassword());
        user.setLastName(registerRequest.getLastName());
        user.setFirstName(registerRequest.getFirstName());
    }

    public static void map(User foundUser, FindUserResponse response){
        response.setFullName(foundUser.getFirstName() + " " + foundUser.getLastName());
        response.setUserId(foundUser.getId());
        response.setUsername(foundUser.getUserName());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd/MM/yyyy, hh:mm a");
        response.setDateRegistered(formatter.format(foundUser.getDateRegistered()));
    }

}
