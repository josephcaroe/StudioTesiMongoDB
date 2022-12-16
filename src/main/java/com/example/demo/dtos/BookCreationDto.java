package com.example.demo.dtos;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class BookCreationDto {
    private String title;
    private String ISBN;
    private String author;
}
