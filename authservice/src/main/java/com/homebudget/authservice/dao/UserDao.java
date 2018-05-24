package com.homebudget.authservice.dao;

import com.homebudget.authservice.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {
    User findByUsername(String username);

    void saveUser(User user);
}
