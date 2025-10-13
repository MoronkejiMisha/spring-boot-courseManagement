package com.Project.CourseManagement.services.Implementations;

import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.repositories.LectureRepository;
import com.Project.CourseManagement.services.LectureService;
import org.springframework.stereotype.Service;

@Service
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public void saveLecture(Lecture lecture){
        lectureRepository.save(lecture);
    }

    public void deleteLectureByName(String name){
        lectureRepository.deleteByNameContaining(name);
    }
}
