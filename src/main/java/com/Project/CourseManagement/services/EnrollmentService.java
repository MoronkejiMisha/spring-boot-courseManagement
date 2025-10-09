package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.CourseEnrollmentDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Student;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private ModelMapper mapper = new ModelMapper();

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    public void enrollStudentById(CourseEnrollmentDto courseEnrollmentDto){
        Student student = studentRepository.findById(courseEnrollmentDto.getStudent_id()).
                orElseThrow(()->new EntityNotFoundException("Student not found"));
        Course course =courseRepository.findByTitleIgnoreCaseContaining(courseEnrollmentDto.getTitle());
        System.out.println(course);
        student.getCourses_enrolled().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }
}

