package com.qa.login.service;

import com.qa.login.model.User;
import com.qa.login.repository.UserRepository;

public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean login(String username,String password){

        if(username == null || password == null)
            return false;

        User user = userRepository.findUser(username);

        if(user == null)
            return false;

        return user.getPassword().equals(password);
    }
}
