package com.courses.internship.Repository;

import com.courses.internship.Model.CourseInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseInstanceRepo extends JpaRepository<CourseInstance,Long> {

    CourseInstance findByIdAndYearAndSemester(Long id, Integer year, Integer semester);

    List<CourseInstance> findByYearAndSemester(Integer year, Integer semester);

    List<CourseInstance> findByYear(Integer year);

    List<CourseInstance> findBySemester(Integer semester);
}
