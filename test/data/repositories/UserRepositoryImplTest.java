package data.repositories;

import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    private UserRepository userRepository;
    private User user;

    @BeforeEach
    public void setUp(){
        userRepository = new UserRepositoryImpl();
        user = new User();
        user.setLastName("Josh");
        user.setLastName("Oluwakuse");
        user.setUserName("Joshrichhy");
        user.setPassword("kuse");
    }
    @Test
    public void saveOneUser_countIsOneTest(){
        userRepository.save(user);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void saveOneUser_idOfUserIsOneTest(){
      User savedUser =  userRepository.save(user);
      assertEquals(1, savedUser.getId());
    }
    @Test
    public void saveTwoUsersWithSameId_countIsOneTest(){
        User savedUser =  userRepository.save(user);
        assertEquals(1, userRepository.count());
        savedUser.setLastName("Felix");
        userRepository.save(savedUser);
        assertEquals(1, userRepository.count());
    }
    @Test
    public void saveOneUser_findByUserIdTest(){
        User savedUser =  userRepository.save(user);
        assertEquals(1, savedUser.getId());
        User foundUser = userRepository.findById(1);
        assertEquals(foundUser, savedUser);
    }
    @Test
    public void saveOneUser_deleteOneUser_CountIsZeroTest(){
        User savedUser =  userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(1);
        assertEquals(0, userRepository.count());
    }
    @Test
    public void saveOneUser_deleteOneUser_CountIsStillZeroTest(){
        User savedUser =  userRepository.save(user);
        assertEquals(1, userRepository.count());
        userRepository.delete(user);
        assertEquals(0, userRepository.count());
    }
}