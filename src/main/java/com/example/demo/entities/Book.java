package com.example.demo.entities;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import lombok.*;

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
    private String title;
    @EqualsAndHashCode.Include private String ISBN;
    private String author;
}