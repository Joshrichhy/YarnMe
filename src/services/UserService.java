package services;

import data.models.User;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;

import java.util.List;

public interface UserService {

    User register(RegisterRequest registerRequest);

    FindUserResponse findUser(int id);

    List<FindUserResponse> findAll();
    void delete(User user);
    void delete(int id);
    void deleteAll();

    FindUserResponse findByUserName(String userName);
    User findId(int id);
}
