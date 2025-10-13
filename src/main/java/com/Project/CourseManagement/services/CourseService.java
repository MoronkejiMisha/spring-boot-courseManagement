package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.CourseDto;
import com.Project.CourseManagement.dto.CourseResponseDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Creator;
import com.Project.CourseManagement.models.Student;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.CreatorRepository;
import com.Project.CourseManagement.repositories.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService {
    private final CreatorRepository creatorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private  ModelMapper mapper = new ModelMapper();
//when mapping the names oof the variables in both classes must be the same
    public CourseResponseDto saveCourse(CourseDto courseDto){
        Course savedCourse =mapper.map(courseDto, Course.class);
        Integer id = courseDto.getCreatorId();
        Creator creators=creatorRepository.findById(id).orElseThrow(() -> new RuntimeException("Creator not found"));
        savedCourse.setCreators(creators);
        savedCourse.setId(null);//this lets hibernate know that it should create a new course and not to update an existing course
        courseRepository.save(savedCourse);
        CourseResponseDto courseResponseDto = mapper.map(savedCourse,CourseResponseDto.class);
        System.out.println(courseResponseDto);
        return courseResponseDto;
    }

    public CourseResponseDto findCourseById(Integer id){
        return mapper.map(courseRepository.findById(id).orElse(new Course()), CourseResponseDto.class);
    }

    public CourseResponseDto findCourseByTitle(String title){
        var findCourse=courseRepository.findByTitleIgnoreCaseContaining(title);
        return mapper.map(findCourse,CourseResponseDto.class);
    }

    public List<CourseResponseDto> findCourseByCreatorsFirstName(String firstName){
        return courseRepository.findByCreators_FirstNameIgnoreCaseContaining(firstName).stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();
    }
    public List<CourseResponseDto> findCourseByCreatorsLastName(String lastName){
        return courseRepository.findByCreators_LastNameIgnoreCaseContaining(lastName).stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();
    }
    public List<CourseResponseDto> findAllCourses(){
        return courseRepository.findAll().stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();

    }

    @Transactional
    @Modifying
    public void deleteByTitle(Integer creatorId,String title){
            Creator creator=creatorRepository.findById(creatorId).
                    orElseThrow(()->new EntityNotFoundException("Creator with this ID does not exist"));
            Course course=courseRepository.findByTitleIgnoreCaseContaining(title);

            if (creator.getCourses().contains(course)){
                courseRepository.deleteByTitleIgnoreCaseContaining(title);
            }
            else{
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }

    }

    @Transactional
    @Modifying
    public void deleteById(Integer creatorId,Integer courseId){
        Creator creator=creatorRepository.findById(creatorId).
                orElseThrow(()->new EntityNotFoundException("Creator with this ID does not exist"));
        Course course=courseRepository.findByCreators_IdAndId(creatorId,courseId);
        if (creator.getCourses().contains(course)) {
            courseRepository.deleteById(courseId);
        }
        else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

    }

//    @Transactional
//    @Modifying
//    public void deleteAllCoursesByCreatorFirstName(String firstName){
//        courseRepository.deleteAllByCreators_FirstNameIgnoreCaseContaining(firstName);
//    }
//
//    @Transactional
//    @Modifying
//    public void deleteAllCoursesByCreatorLastName(String lastName){
//        courseRepository.deleteAllByCreators_LastNameIgnoreCaseContaining(lastName);
//    }
}
