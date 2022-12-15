package com.example.demo.command;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCommand {
    @Autowired
    private UserService userService;
    public User addNewUser(User user){
        return userService.saveUser(user);
    }
}