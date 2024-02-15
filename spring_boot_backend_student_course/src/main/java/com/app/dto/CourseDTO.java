package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDTO {

	private String title;

	private LocalDate startDate;

	private LocalDate endDate;

	private double fees;

	private int minScore;

}
