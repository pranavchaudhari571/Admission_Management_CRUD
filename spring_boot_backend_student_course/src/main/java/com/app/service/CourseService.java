package com.app.service;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;

public interface CourseService {

	ApiResponse launchNewCourse(CourseDTO courseDTO);

	ApiResponse updateCourseFees(Long courseId, double newFees);
}
