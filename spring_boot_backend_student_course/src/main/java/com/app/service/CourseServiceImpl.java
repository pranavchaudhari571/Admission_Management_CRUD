package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CourseDao;
import com.app.dto.ApiResponse;
import com.app.dto.CourseDTO;
import com.app.entities.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public ApiResponse launchNewCourse(CourseDTO courseDTO) {
        Course course = new Course();
        course.setTitle(courseDTO.getTitle());
        course.setStartDate(courseDTO.getStartDate());
        course.setEndDate(courseDTO.getEndDate());
        course.setFees(courseDTO.getFees());
        course.setMinScore(courseDTO.getMinScore());

        courseDao.save(course);
        
        ApiResponse response = new ApiResponse();
        response.setMessage("New course launched successfully.");
        return response;
    }

    @Override
    public ApiResponse updateCourseFees(Long courseId, double newFees) {
        Optional<Course> optionalCourse = courseDao.findById(courseId);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setFees(newFees);
            courseDao.save(course);

            ApiResponse response = new ApiResponse();
            response.setMessage("Course fees updated successfully.");
            return response;
        } else {
            ApiResponse response = new ApiResponse();
            response.setMessage("Course not found.");
            return response;
        }
    }
}
