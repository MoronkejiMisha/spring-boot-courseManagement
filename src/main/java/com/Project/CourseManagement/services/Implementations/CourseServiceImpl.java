package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.*;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Creator;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.CreatorRepository;
import com.Project.CourseManagement.repositories.StudentRepository;
import com.Project.CourseManagement.services.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private static final Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CreatorRepository creatorRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private ModelMapper mapper = new ModelMapper();

    //when mapping the names oof the variables in both classes must be the same
    public CourseResponseDto saveCourse(CourseDto courseDto) {
        Course savedCourse = mapper.map(courseDto, Course.class);
        Integer id = courseDto.getCreatorId();
        Creator creators = creatorRepository.findById(id).orElseThrow(() -> new RuntimeException("Creator not found"));
        savedCourse.setCreators(creators);
        savedCourse.setId(null);//this lets hibernate know that it should create a new course and not to update an existing course
        courseRepository.save(savedCourse);
        CourseResponseDto courseResponseDto = mapper.map(savedCourse, CourseResponseDto.class);
        System.out.println(courseResponseDto);
        return courseResponseDto;
    }

    public CourseResponseDto findCourseById(Integer id) {
        return mapper.map(courseRepository.findById(id).orElse(new Course()), CourseResponseDto.class);
    }

    public CourseResponseDto findCourseByTitle(String title) {
        var findCourse = courseRepository.findByTitleIgnoreCaseContaining(title);
        return mapper.map(findCourse, CourseResponseDto.class);
    }

    public List<CourseResponseDto> findCourseByCreatorsFirstName(String firstName) {
        return courseRepository.findByCreators_FirstNameIgnoreCaseContaining(firstName).stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();
    }

    public List<CourseResponseDto> findCourseByCreatorsLastName(String lastName) {
        return courseRepository.findByCreators_LastNameIgnoreCaseContaining(lastName).stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();
    }

    public List<CourseResponseDto> findAllCourses() {
        return courseRepository.findAll().stream().map(course -> mapper.map(course, CourseResponseDto.class)).toList();

    }

    @Transactional
    @Modifying
    public void deleteCourse(Integer creatorId, Integer courseId) {
        Course course = courseRepository.findByCreators_IdAndId(creatorId, courseId);
        if (course == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "course not owned by this creator");
        } else {
            courseRepository.delete(course);
        }
    }

    public void updateCourse(Integer creatorId, Integer courseId, CourseUpdateDto courseUpdateDto) {
        Course course = courseRepository.findByCreators_IdAndId(creatorId, courseId);
        if (course != null) {
            if (courseUpdateDto.getTitle() != null) {
                course.setTitle(courseUpdateDto.getTitle());
            }
            if (courseUpdateDto.getDescription() != null) {
                course.setDescription(courseUpdateDto.getDescription());
            }
            if (courseUpdateDto.getContent() != null) {
                course.setContent(courseUpdateDto.getContent());
            }
            log.info(String.valueOf(course.toString()));
            courseRepository.save(course);
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }


}
