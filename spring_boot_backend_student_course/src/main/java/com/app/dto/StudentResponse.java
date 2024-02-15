package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private String firstName;

    private String lastName;

    private String email;

    private double scoreObtained;

    
}