package com.example.demo.command;

import com.example.demo.entities.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookCommand {
    @Autowired private BookService bookService;

    public Book addNewBook(Book b){
        return bookService.addBook(b);
    }
}
