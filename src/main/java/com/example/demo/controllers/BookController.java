package com.example.demo.controllers;

import com.example.demo.command.BookCommand;
import com.example.demo.command.UserCommand;
import com.example.demo.dtos.BookCreationDto;
import com.example.demo.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/books", produces="application/json")
public class BookController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired private BookCommand bookCommand;


    @PostMapping("/addBook")
    public ResponseEntity<Book> createBook(BookCreationDto book){
         Book b = modelMapper.map(book, Book.class);
         bookCommand.addNewBook(b);
        return new ResponseEntity<>(b, HttpStatus.CREATED);
    }
}
