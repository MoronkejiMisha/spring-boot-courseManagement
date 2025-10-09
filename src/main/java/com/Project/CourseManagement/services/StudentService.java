package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.StudentDto;
import com.Project.CourseManagement.models.Student;
import com.Project.CourseManagement.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper mapper = new ModelMapper();

    public void saveStudent(StudentDto studentDto){
        studentRepository.save(mapper.map(studentDto, Student.class));
    }

    public StudentDto findStudentById(Integer id){
        return mapper.map(studentRepository.findById(id).orElse(new Student()), StudentDto.class);
    }
    public StudentDto findStudentByFirstName(String firstName){
        var student= studentRepository.findByFirstNameContaining(firstName);
        return mapper.map(student, StudentDto.class);
    }
    public StudentDto findStudentByLastName(String lastName){
        var student= studentRepository.findByLastNameContaining(lastName);
        return mapper.map(student, StudentDto.class);
    }
    public StudentDto findStudentByName(String firstName, String lastName){
        var student= studentRepository.findByFirstNameAndLastNameContaining(firstName,lastName);
        return mapper.map(student, StudentDto.class);
    }

    public List<StudentDto> findAllStudents(){
        return studentRepository.findAll().stream().map(student -> mapper.map(student, StudentDto.class)).toList();

    }

    public void deleteCourseById(Integer id){
        studentRepository.deleteById(id);
    }

}
