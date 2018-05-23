package com.homebudget.userservice.controllers;

import com.homebudget.userservice.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("")
    public Collection<User> getUsers() {
        return null;
    }

    @GetMapping("/{id}")
    public User getUserWithId(@PathVariable(value = "id") String id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUserWithId(@PathVariable(value = "id") String id) {

    }

    @PostMapping("")
    public void createUser(@RequestBody User user) {

    }

    @PatchMapping("/{id}")
    public void updateUser(@PathVariable(value = "id") String id) {

    }

}
