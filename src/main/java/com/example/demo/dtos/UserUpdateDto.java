package com.example.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class UserUpdateDto {

    private String firstName;
    private String lastName;
    private String password;
    private BookCreationDto book;

}
