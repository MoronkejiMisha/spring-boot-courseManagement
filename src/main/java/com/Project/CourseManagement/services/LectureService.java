package com.Project.CourseManagement.services;

import com.Project.CourseManagement.models.Lecture;
import com.Project.CourseManagement.repositories.LectureRepository;

public interface LectureService {
    void saveLecture(Lecture lecture);
    void deleteLectureByName(String name);
}
