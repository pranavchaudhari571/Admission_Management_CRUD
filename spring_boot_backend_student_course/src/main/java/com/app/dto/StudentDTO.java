package com.app.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentDTO {

	private String firstName;

	private String lastName;

	private String email;

	private double scoreObtained;

	private Long courseId;

}
