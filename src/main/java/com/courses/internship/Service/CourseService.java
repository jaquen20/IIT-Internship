package com.courses.internship.Service;

import com.courses.internship.Model.Course;
import com.courses.internship.Repository.CourseInstanceRepo;
import com.courses.internship.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    public CourseRepository courseRepository;


    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public List<Course> findAllCourses() {
        List<Course> courseList=courseRepository.findAll();
        if (courseList.isEmpty()){
            return Collections.emptyList();
        }else return courseList;
//      return   courseRepository.findAll();
    }

    public Course getDetailsById(Long id) {
        Optional<Course> course=courseRepository.findById(id);
        return course.orElse(null);
    }

    public void deleteById(Long id) {
        Optional<Course> course=courseRepository.findById(id);
        if (course.isPresent()){
            courseRepository.deleteById(id);
        }
    }

    public Course getDataById(Long id) {
        Optional<Course> course= courseRepository.findById(id);
        if (course.isPresent()){
            return course.get();
        }else return null;
    }
}
