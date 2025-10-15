package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.SectionDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Section;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.SectionRepository;
import com.Project.CourseManagement.services.SectionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SectionServiceImpl implements SectionService {
    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;

    private ModelMapper mapper = new ModelMapper();

    public void addSection(Integer courseId,SectionDto sectionDto){
        Section section=mapper.map(sectionDto, Section.class);
        Course course=courseRepository.findById(courseId)
                .orElseThrow(()->new RuntimeException("Course not found"));
        section.setId(null);
        section.setCourses(course);
        courseRepository.save(course);
        sectionRepository.save(section);
    }
    public List<SectionDto> getAllSections(){
        return sectionRepository.findAll().stream().map(section -> mapper.map(section, SectionDto.class)).toList();
    }

    public SectionDto getSectionsById(Integer sectionId){
        Section section=sectionRepository.findById(sectionId).orElseThrow(()->new RuntimeException("No such section was found"));
        return mapper.map(section, SectionDto.class);
    }

    @Transactional
    public void deleteSectionById(Integer courseId,Integer sectionId){
        Section section=sectionRepository.findByIdAndCourses_Id(sectionId,courseId);
        if (section==null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        else{
            sectionRepository.delete(section);
        }
    }
}
