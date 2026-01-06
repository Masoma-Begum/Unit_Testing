package com.qa.login.tests;

import com.qa.login.model.User;
import com.qa.login.repository.UserRepository;
import com.qa.login.service.LoginService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {
    private UserRepository repo;
    private LoginService loginService;

    @BeforeEach
    public void setup(){
        repo = Mockito.mock(UserRepository.class);
        loginService = new LoginService(repo);
    }

    @Test
    public void validLogin_shouldReturnTrue(){

        User mockUser = new User("standard_user","secret_sauce");

        Mockito.when(repo.findUser("standard_user"))
                .thenReturn(mockUser);

        boolean result =
                loginService.login("standard_user","secret_sauce");

       assertTrue(result);
        // Verify that repo.findUser() was called exactly once
        Mockito.verify(repo).findUser("standard_user");

    }

    @Test
    public void invalidPassword_shouldReturnFalse(){

        User mockUser = new User("standard_user","secret_sauce");

        Mockito.when(repo.findUser("standard_user"))
                .thenReturn(mockUser);

        boolean result =
                loginService.login("standard_user","wrong_password");

        assertFalse(result);
        // Verify that repo.findUser() was called exactly once
        Mockito.verify(repo).findUser("standard_user");

    }

    @Test
    public void userNotExists_shouldReturnFalse(){

        Mockito.when(repo.findUser("ghost"))
                .thenReturn(null);

        boolean result =
                loginService.login("ghost","pass");

        assertFalse(result);
        // Verify repo.findUser() call
        Mockito.verify(repo).findUser("ghost");
    }

}

