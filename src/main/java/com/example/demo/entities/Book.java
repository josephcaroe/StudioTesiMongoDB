package com.example.demo.entities;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import lombok.*;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/*@Embedded("book_table") embedded è stato deprecato, ora si usa entity ovunque, anche se si tratta
di un documento interno ad un altro*/
@Entity("book_table")
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Book {
    @Id
    private ObjectId id;
    private String title;
    @EqualsAndHashCode.Include private String ISBN;
    private String author;
}