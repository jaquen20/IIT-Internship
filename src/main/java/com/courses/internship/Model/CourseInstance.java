package com.courses.internship.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data @Entity
public class CourseInstance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer year;
    private Integer semester;

    @ManyToOne
    private Course course;
}
