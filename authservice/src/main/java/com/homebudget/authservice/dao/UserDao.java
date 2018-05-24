package com.homebudget.authservice.dao;

import com.homebudget.authservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserDao {
    Collection<User> findAllUsers();

    User findByUsername(String username);

    void saveUser(User user);
}
