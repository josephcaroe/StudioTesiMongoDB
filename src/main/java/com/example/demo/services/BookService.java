package com.example.demo.services;

import com.example.demo.entities.Book;
import dev.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired private Datastore mongoDB;

    public Book addBook(Book book){
        return mongoDB.save(book);
    }
}
