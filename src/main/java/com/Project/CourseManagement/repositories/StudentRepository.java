package com.Project.CourseManagement.repositories;

import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    public Student findByFirstNameContaining(String firstName);
    public Student findByLastNameContaining(String lastName);
    public Student findByFirstNameAndLastNameContaining(String firstName, String LastName);
    Student findByCoursesEnrolled_IdAndId(Integer courseId, Integer studentId);

}
