package data.repositories;

import data.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {

    private int count;
    private static List<User> users = new ArrayList<>();

    @Override
    public  User save(User user) {
        boolean userHasNotBeenSaved = user.getId() == 0;
        if(userHasNotBeenSaved){
        user.setId(generateUserId());
        users.add(user);
        count++;
        }
        return user;
    }

    private int generateUserId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for (User user : users) if (user.getId() == id) return user;
        throw  new NullPointerException("User Id not found");
        }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public void delete(User user) {
        for (User userIn : users) {
            if(userIn== user) {users.remove(user);
                count--; break;}}

    }

    @Override
    public void delete(int id) {
        for (User user : users) {
            if(user.getId() == id) {
            users.remove(user);
            count--;
            break;}}
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public User findByUserName(String userName) {
        for (User user : users){
            if(Objects.equals(user.getUserName(), userName)){
                return user;}}
        return null;
    }

    @Override
    public int findId(int id) {
        for (User user : users) {
            if(user.getId() == id){ return id;  }
            else{throw new NullPointerException("Id not found");}

        } return 0;
    }
}
