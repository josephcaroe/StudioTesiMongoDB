package com.example.demo.entities;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import lombok.*;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Entity("user_table")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {
    @Id
    private ObjectId id; /*lo creo così...? o creo una factory di ID?*/
    @Property("nome")
    private String firstName;
    @Property("cognome")
    private String lastName;
    @EqualsAndHashCode.Include private String email;
    private String password;
    @Reference
    private List<Book> books = new ArrayList<>();

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
    public void addBook(Book b){
        if(this.books == null){
            books = new ArrayList<>();
        }
        books.add(b);
    }
}