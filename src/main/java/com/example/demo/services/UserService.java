package com.example.demo.services;

import com.example.demo.dtos.UserUpdateDto;
import com.example.demo.entities.Book;
import com.example.demo.entities.User;
import dev.morphia.Datastore;
import dev.morphia.UpdateOptions;
import dev.morphia.query.Query;
import dev.morphia.query.filters.Filters;
import dev.morphia.query.updates.UpdateOperators;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private Datastore mongoDB;

    @Autowired
    private ModelMapper modelMapper;

    public User saveUser(User user){
        return mongoDB.save(user);
    }

    public User findUserByUsername(String username) {
        Query<User> query = mongoDB.find(User.class);
        query.filter(Filters.eq("email", username));
        User u = query.stream().iterator().next();
        return u;
    }

    public User updateUserByUsername(String username, UserUpdateDto userDetails) {

        mongoDB.find(User.class).filter(Filters.eq("email", username)).
                update(new UpdateOptions(),
                        UpdateOperators.set("firstName", userDetails.getFirstName()),
                        UpdateOperators.set("lastName", userDetails.getLastName()),
                        UpdateOperators.set("password", userDetails.getPassword()),
                        UpdateOperators.addToSet("books", modelMapper.map(userDetails.getBook(), Book.class))
                );
        return mongoDB.find(User.class).filter(Filters.eq("email", username)).first();
        }
/*        User toUpdate = findUserByUsername(username);
        updateUserDetails(toUpdate, userDetails);
        mongoDB.save(toUpdate);
        return toUpdate;*/
    private void updateUserDetails(User user, UserUpdateDto userDetails){
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setPassword(userDetails.getPassword());
        user.addBook(modelMapper.map(userDetails.getBook(), Book.class));
    }
}