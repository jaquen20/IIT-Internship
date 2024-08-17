package com.courses.internship.Controller;

import com.courses.internship.Model.Course;
import com.courses.internship.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/courseList")
public class CourseController {
    @Autowired
    public CourseService courseService;

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course){
        if (course!=null){
            courseService.saveCourse(course);
            return ResponseEntity.ok("saved successfully");
        }
        else return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("empty data");
    }

    @GetMapping
    public ResponseEntity<?> getCourseList(){
        List<Course> courseList=courseService.findAllCourses();
        return new ResponseEntity<>(courseList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> detailsById(@PathVariable Long id){
        Course course=courseService.getDetailsById(id);
        if (course!=null){
            return ResponseEntity.ok(course);
        }else return new ResponseEntity<>("not found",HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> deleteById(@PathVariable Long id){
        courseService.deleteById(id);
        return new ResponseEntity<>("ok",HttpStatus.BAD_REQUEST);
    }
}
