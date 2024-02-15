package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dao.StudentDao;
import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.dto.StudentResponse;
import com.app.entities.Course;
import com.app.entities.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private CourseDao courseDao;

	@Override
	public ApiResponse addStudent(StudentDTO studentDTO) {
		double minScore = courseDao.findById(studentDTO.getCourseId()).map(Course::getMinScore).orElseThrow();

		if (studentDTO.getScoreObtained() >= minScore) {
			Student student = new Student();
			student.setFirstName(studentDTO.getFirstName());
			student.setLastName(studentDTO.getLastName());
			student.setEmail(studentDTO.getEmail());
			student.setScoreObtained(studentDTO.getScoreObtained());

			Course course = courseDao.findById(studentDTO.getCourseId()).orElseThrow();
			student.setCourse(course);

			studentDao.save(student);

			ApiResponse response = new ApiResponse();
			response.setMessage("Student added successfully.");
			return response;
		} else {
			ApiResponse response = new ApiResponse();
			response.setMessage("Admission denied. Score is below the minimum required.");
			return response;
		}
	}

	@Override
	public void cancelAdmission(Long courseId, Long studentId) {
		Optional<Student> optionalStudent = studentDao.findById(studentId);
		if (optionalStudent.isPresent() && optionalStudent.get().getCourse().getId().equals(courseId)) {
			studentDao.deleteById(studentId);
		}
	}

	@Override
	public List<StudentResponse> getAllStudentsForCourse(String courseTitle) {
	    return studentDao.findByCourse_Title(courseTitle)
	            .stream()
	            .map(student -> new StudentResponse(
	                    student.getFirstName(),
	                    student.getLastName(),
	                    student.getEmail(),
	                    student.getScoreObtained()))
	            .collect(Collectors.toList());
	}
}
