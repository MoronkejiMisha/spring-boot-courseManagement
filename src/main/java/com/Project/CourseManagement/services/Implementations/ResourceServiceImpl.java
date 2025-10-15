package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.ResourceDto;
import com.Project.CourseManagement.models.Course;
import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.models.Resource;
import com.Project.CourseManagement.repositories.CourseRepository;
import com.Project.CourseManagement.repositories.LectureRepository;
import com.Project.CourseManagement.repositories.ResourceRepository;
import com.Project.CourseManagement.services.ResourceService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ResourceServiceImpl implements ResourceService {
    private final LectureRepository lectureRepository;
    private final ResourceRepository resourceRepository;
    private final CourseRepository courseRepository;
    private ModelMapper mapper = new ModelMapper();

    public void addResource(Integer lectureId,ResourceDto resourceDto){
        Resource resource=mapper.map(resourceDto, Resource.class);
        Lecture lecture=lectureRepository.findById(lectureId).orElseThrow(()->new RuntimeException("No such lecture was found"));

        resource.setId(null);
        resource.setLectures(lecture);
        lecture.getResources().add(resource);

        resourceRepository.save(resource);
        lectureRepository.save(lecture);
    }
    public ResourceDto getResourceById(Integer resourceId){
        Resource resource=resourceRepository.findById(resourceId).orElseThrow(()->new RuntimeException("No such lecture was found"));
        return mapper.map(resource, ResourceDto.class);
    }

    public List<ResourceDto> getAllResources(){
        return resourceRepository.findAll().stream().map(resource->mapper.map(resource, ResourceDto.class)).toList();
    }
    @Transactional
    @Modifying
    public void deleteResource(Integer courseId,Integer sectionId,Integer lectureId,Integer resourceId){
        Resource resource=resourceRepository.findByIdAndLectures_IdAndLectures_Sections_IdAndLectures_Sections_Courses_Id(resourceId,lectureId,sectionId,courseId);
        if (resource == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        else {
            resourceRepository.delete(resource);
        }
    }
}
