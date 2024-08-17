package com.courses.internship.Service;

import com.courses.internship.Model.Course;
import com.courses.internship.Model.CourseInstance;
import com.courses.internship.Repository.CourseInstanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CourseInstanceService {

    @Autowired
    public CourseInstanceRepo courseInstanceRepo;

    public void saveCourseInstance(CourseInstance courseInstance) {
        courseInstanceRepo.save(courseInstance);
    }

    public List<CourseInstance> findAllCoursesWithInstance() {
        return courseInstanceRepo.findAll();
    }

    public CourseInstance getDetailsById(Long id) {
        Optional<CourseInstance> courseInstance= courseInstanceRepo.findById(id);
        return courseInstance.orElse(null);

    }

    public void deleteById(Long id) {

    }

    public CourseInstance findByQuery(Long id, Integer year, Integer semester) {
        return courseInstanceRepo.findByIdAndYearAndSemester(id,year,semester);

    }

    public List<CourseInstance> searchQuery(Integer year, Integer semester) {
        if (year!=null && semester!=null){
            return courseInstanceRepo.findByYearAndSemester(year,semester);
        }else if(year!=null){
            return courseInstanceRepo.findByYear(year);
        }else if(semester!=null) {
            return courseInstanceRepo.findBySemester(semester);
        }else return courseInstanceRepo.findAll();

    }
}
