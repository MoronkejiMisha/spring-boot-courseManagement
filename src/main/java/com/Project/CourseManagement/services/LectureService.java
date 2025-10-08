package com.Project.CourseManagement.services;

import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.repositories.LectureRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public void saveLecture(Lecture lecture){
        lectureRepository.save(lecture);
    }

    public void deleteLectureByName(String name){
        lectureRepository.deleteByNameContaining(name);
    }
}
