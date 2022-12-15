package com.example.demo.services;

import com.example.demo.entities.User;
import dev.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private Datastore mongoDB;

    public User saveUser(User user){
        return mongoDB.save(user);
    }
}
