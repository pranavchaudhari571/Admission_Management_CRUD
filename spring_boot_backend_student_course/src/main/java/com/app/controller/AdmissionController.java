package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponse;
import com.app.entities.Student;
import com.app.service.CourseService;
import com.app.service.StudentService;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@PostMapping("/courses")
	public ApiResponse launchNewCourse(@RequestBody CourseDTO courseDTO) {
		return courseService.launchNewCourse(courseDTO);
	}

	@PostMapping("/students")
	public ApiResponse addStudent(@RequestBody StudentDTO studentDTO) {
		return studentService.addStudent(studentDTO);
	}

	@GetMapping("/students/course_title/{courseTitle}")
	public List<StudentResponse> getAllStudentsForCourse(@PathVariable String courseTitle) {
		return studentService.getAllStudentsForCourse(courseTitle);
	}

	@PutMapping("/courses/{courseId}/fees/{newFees}")
	public ApiResponse updateCourseFees(@PathVariable Long courseId, @PathVariable double newFees) {
		return courseService.updateCourseFees(courseId, newFees);
	}

	@DeleteMapping("/courses/{courseId}/students/{studentId}")
	public void cancelAdmission(@PathVariable Long courseId, @PathVariable Long studentId) {
		studentService.cancelAdmission(courseId, studentId);
	}
}
