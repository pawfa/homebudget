package com.homebudget.authservice.controllers;

import com.homebudget.authservice.entity.User;
import com.homebudget.authservice.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final Log logger = LogFactory.getLog(getClass());
    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthController(UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/token")
    public void getToken(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
    }

    @PostMapping("")
    public void getAllUsers() {

        Collection<User> col = userService.findAllUsers();
        logger.info(col);
        col.forEach((e)-> logger.info(e.getEmail()));
    }
}
