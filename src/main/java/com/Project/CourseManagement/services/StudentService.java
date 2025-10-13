package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.StudentDto;
import com.Project.CourseManagement.models.Student;
import com.Project.CourseManagement.repositories.StudentRepository;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface StudentService {

    public void saveStudent(StudentDto studentDto);

    public StudentDto findStudentById(Integer id);

    public StudentDto findStudentByFirstName(String firstName);

    public StudentDto findStudentByLastName(String lastName);

    public StudentDto findStudentByName(String firstName, String lastName);

    public List<StudentDto> findAllStudents();

    public void deleteCourseById(Integer id);
}