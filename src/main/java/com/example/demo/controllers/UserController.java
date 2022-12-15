package com.example.demo.controllers;
import com.example.demo.dtos.UserCreationDto;
import com.example.demo.command.UserCommand;
import com.example.demo.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/users", produces="application/json")

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
}