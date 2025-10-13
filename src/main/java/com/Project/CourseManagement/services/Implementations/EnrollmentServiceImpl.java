package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.CourseEnrollmentDto;
import com.Project.CourseManagement.dto.StudentEnrollmentResponseDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Student;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.StudentRepository;
import com.Project.CourseManagement.services.EnrollmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private ModelMapper mapper = new ModelMapper();

    private final CourseRepository courseRepository;

    private final StudentRepository studentRepository;

    public void enrollStudentById(CourseEnrollmentDto courseEnrollmentDto){
        Student student = studentRepository.findById(courseEnrollmentDto.getStudent_id()).
                orElseThrow(()->new EntityNotFoundException("Student not found"));
        Course course =courseRepository.findByTitleIgnoreCaseContaining(courseEnrollmentDto.getTitle());
        System.out.println(course);
        student.getCoursesEnrolled().add(course);
        course.getStudents().add(student);
        studentRepository.save(student);
        courseRepository.save(course);
    }

    public void deleteEnrollment(Integer studentId,Integer courseId){
        Course course=courseRepository.findById(courseId).
                orElseThrow(()->new EntityNotFoundException("Course does not exist"));

        Student student=studentRepository.findByCoursesEnrolled_IdAndId(courseId,studentId);

        if (student.getCoursesEnrolled().contains(course)){
            course.getStudents().remove(student);
            student.getCoursesEnrolled().remove(course);
            courseRepository.save(course);
            studentRepository.save(student);
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }

    public List<Course> getCoursesEnrolled(Integer id){
        Student student = studentRepository.findById(id).
                orElseThrow(()->new EntityNotFoundException("Course does not exist"));
        return student.getCoursesEnrolled();
    }

    public List<StudentEnrollmentResponseDto> getStudentsEnrolled(Integer id) {
        Course course = courseRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Course does not exist"));
        return course.getStudents().stream().map(student->mapper.map(student,StudentEnrollmentResponseDto.class)).toList();
    }
}

