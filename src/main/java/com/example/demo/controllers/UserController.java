package com.example.demo.controllers;
import com.example.demo.dtos.UserCreationDto;
import com.example.demo.command.UserCommand;
import com.example.demo.dtos.UserUpdateDto;
import com.example.demo.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/users", produces="application/json")
@Slf4j
public class UserController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired private UserCommand userCommand;

    @PostMapping("/addUser")
    public ResponseEntity<User> createNewUser(@RequestBody UserCreationDto userDTO){
        User newUser = modelMapper.map(userDTO, User.class);
        userCommand.addNewUser(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/{username}")
    public ResponseEntity<User> updateUser(@PathVariable String username, @RequestBody UserUpdateDto user){
        Optional<User> us = Optional.of(userCommand.findUserByUsername(username));
        if(us.isPresent()){
            User updated = userCommand.updateUser(username, user);
            return new ResponseEntity<>(updated, HttpStatus.CREATED);
        }else return new ResponseEntity<>(new User(), HttpStatus.EXPECTATION_FAILED);
    }
}