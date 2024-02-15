# Admission Management System

This is a RESTful Spring Boot application for managing courses and student admissions.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [API Endpoints](#api-endpoints)

## Overview

The Admission Management System provides APIs for launching new courses, adding students to courses, retrieving students enrolled in a specific course, updating course fees, and canceling student admissions.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- H2 Database (in-memory database)
- Maven

## Setup Instructions

1. **Clone the repository:**

    ```bash
    git clone <repository-url>
    ```

2. **Navigate to the project directory:**

    ```bash
    cd admission-management-system
    ```

3. **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

4. **Run the application:**

    ```bash
    java -jar target/admission-management-system.jar
    ```

5. The application will start running on `http://localhost:8080`.

## API Endpoints

- **Launch New Course:**

  `POST /admission/courses`
  
  Request Body: CourseDTO
  
- **Add Student:**

  `POST /admission/students`
  
  Request Body: StudentDTO
  
- **Get All Students for Course:**

  `GET /admission/students/course_title/{courseTitle}`
  
  Path Variable: courseTitle
  
- **Update Course Fees:**

  `PUT /admission/courses/{courseId}/fees/{newFees}`
  
  Path Variables: courseId, newFees
  
- **Cancel Admission:**

  `DELETE /admission/courses/{courseId}/students/{studentId}`
  
  Path Variables: courseId, studentId

