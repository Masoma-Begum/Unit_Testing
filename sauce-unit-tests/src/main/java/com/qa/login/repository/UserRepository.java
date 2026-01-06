package com.qa.login.repository;

import com.qa.login.model.User;

public interface UserRepository {
    User findUser(String username);

}
