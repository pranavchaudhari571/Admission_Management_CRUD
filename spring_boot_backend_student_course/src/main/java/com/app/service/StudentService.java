package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponse;

public interface StudentService {

	ApiResponse addStudent(StudentDTO studentDTO);
    void cancelAdmission(Long courseId, Long studentId);
    List<StudentResponse> getAllStudentsForCourse(String courseTitle);

}
