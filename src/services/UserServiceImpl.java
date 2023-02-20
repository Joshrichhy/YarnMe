package services;

import data.models.User;
import data.repositories.UserRepository;
import data.repositories.UserRepositoryImpl;
import dtos.requests.RegisterRequest;
import dtos.responses.FindUserResponse;
import utils.Mapper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public User register(RegisterRequest registerRequest) {
        if (userExist(registerRequest.getUserName())) throw new IllegalArgumentException(registerRequest.getUserName() + " already exists");
        return userRepository.save(Mapper.map(registerRequest));

//        or
//                User user = new User();
//        Mapper.map(registerRequest, user);
//        return userRepository.save(user);

    }

    @Override
    public FindUserResponse findUser(int id) {
        User foundUser =  userRepository.findById(id);
        FindUserResponse response = new FindUserResponse();
        Mapper.map(foundUser, response);
        return response;
    }

    @Override
    public List<FindUserResponse> findAll() {
        ArrayList <FindUserResponse> allUsers = new ArrayList<>();
        allUsers.add((FindUserResponse) userRepository.findAll());
        return allUsers;
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public FindUserResponse findByUserName(String userName) {
        return null;
    }

    private boolean userExist(String userName) {
        User foundUser = userRepository.findByUserName(userName);
        if (foundUser != null) return true;
        return false;
    }
    public User findId(int id){
        return userRepository.findById(id);
    }


}
