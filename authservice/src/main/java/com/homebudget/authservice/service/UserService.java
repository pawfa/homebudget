package com.homebudget.authservice.service;

import com.homebudget.authservice.dao.UserDao;
import com.homebudget.authservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    UserDao userDao;

    UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void save(User user) {
        userDao.saveUser(user);
    }

    public Collection<User> findAllUsers() {
        return userDao.findAllUsers();
    }
}
