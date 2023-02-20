package services;

import data.models.User;
import dtos.requests.RegisterRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {

    private UserService userService;
    private RegisterRequest registerRequest;

    @BeforeEach
    public void setUp(){
        registerRequest = new RegisterRequest();
        userService = new UserServiceImpl();

        registerRequest.setFirstName("Josh");
        registerRequest.setLastName("Oluwakuse");
        registerRequest.setUserName("Joshrichhy");
        registerRequest.setPassword("password");
    }
    @Test
    public void test_SaveNewUser_IdIsNotZero(){

        User savedUser = userService.register(registerRequest);
        assertTrue(savedUser.getId() != 0);
    }

    @Test
    public void test_duplicateUserNameThrowsException(){
        registerRequest.setFirstName("Jeremiah");
        registerRequest.setLastName("Oluwakuse");
        registerRequest.setUserName("Joshrichhy");
        registerRequest.setPassword("password");
        User savedUser = userService.register(registerRequest);
        assertThrows(IllegalArgumentException.class, () -> userService.register(registerRequest));
    }

    @Test
    public void test_findUserById(){
        userService.register(registerRequest);

         RegisterRequest  registerRequest2 = new RegisterRequest();

        registerRequest2.setFirstName("Jennifer");
        registerRequest2.setLastName("Musah");
        registerRequest2.setUserName("Jennifer");
        registerRequest2.setPassword("password");
        userService.register(registerRequest2);
        assertEquals("Josh Oluwakuse", userService.findUser(1).getFullName());
        assertEquals("Jennifer Musah", userService.findUser(2).getFullName());
    }

    @Test
    public void test_ThrowExceptionWhenIdIsWrong(){
        userService.register(registerRequest);
        System.out.println(userService.toString());
        assertThrows(NullPointerException.class, () ->  userService.findUser(2));
    }
}