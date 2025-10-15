package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.dto.LectureDto;
import com.Project.CourseManagement.dto.ResourceDto;
import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.models.Resource;
import com.Project.CourseManagement.models.Section;
import com.Project.CourseManagement.repositories.LectureRepository;
import com.Project.CourseManagement.repositories.SectionRepository;
import com.Project.CourseManagement.services.LectureService;
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
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final SectionRepository sectionRepository;

    private ModelMapper mapper = new ModelMapper();
    public void saveLecture(Integer sectionId,LectureDto lectureDto){
        Lecture lecture=mapper.map(lectureDto, Lecture.class);
        Section section = sectionRepository.findById(sectionId).
                orElseThrow(()->new RuntimeException("Section not found"));
        lecture.setSections(section);
        lecture.setId(null);
        section.getLectures().add(lecture);
        lectureRepository.save(lecture);
        sectionRepository.save(section);
    }
    public List<LectureDto> getAllLectures(){
        return lectureRepository.findAll().stream().map(lecture -> mapper.map(lecture, LectureDto.class)).toList();
    }
    public LectureDto getLectureById(Integer lectureId){
        Lecture lecture=lectureRepository.findById(lectureId).orElseThrow(()->new RuntimeException("No such lecture was found"));
        return mapper.map(lecture, LectureDto.class);
    }

    @Transactional
    @Modifying
    public void deleteLectureById(Integer courseId,Integer sectionId,Integer lectureId){
        Lecture lecture=lectureRepository.findByIdAndSections_IdAndSections_Courses_Id(lectureId,sectionId,courseId);
        if (lecture == null){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        else {
            lectureRepository.delete(lecture);
        }

    }
}
