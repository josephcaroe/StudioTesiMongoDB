package com.example.demo.command;

import com.example.demo.dtos.UserUpdateDto;
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
    public User findUserByUsername(String username){return userService.findUserByUsername(username);}

    public User updateUser(String username, UserUpdateDto dto){return userService.updateUserByUsername(username, dto);}
}