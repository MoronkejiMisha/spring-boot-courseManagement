package com.Project.CourseManagement.services;

import com.Project.CourseManagement.dto.LectureDto;

import java.util.List;

public interface LectureService {
    List<LectureDto> getAllLectures();
    LectureDto getLectureById(Integer lectureId);
    void saveLecture(Integer sectionId,LectureDto lectureDto);
    void deleteLectureById(Integer courseId,Integer sectionId,Integer lectureId);
}
