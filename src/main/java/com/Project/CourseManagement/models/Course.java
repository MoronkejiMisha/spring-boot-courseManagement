package com.Project.CourseManagement.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    @JsonBackReference
    private Creator creators;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="enrollment",
            joinColumns = @JoinColumn(name="course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonBackReference
    private List<Student> students =new ArrayList<>();

    @OneToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Section> sections=new ArrayList<>();

}
