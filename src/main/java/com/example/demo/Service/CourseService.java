package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.CourseRepository;
import com.example.demo.entity.Course;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        Course existingCourse = getCourseById(id);

        // Update properties if they are not null
        if (course.getCourseName() != null) {
            existingCourse.setCourseName(course.getCourseName());
        }
        if (course.getDescription() != null) {
            existingCourse.setDescription(course.getDescription());
        }
        if (course.getTeacher() != null) {
            existingCourse.setTeacher(course.getTeacher());
        }
        if (course.getStartDate() != null) {
            existingCourse.setStartDate(course.getStartDate());
        }
        if (course.getEndDate() != null) {
            existingCourse.setEndDate(course.getEndDate());
        }
        if (course.getCapacity() > 0) {
            existingCourse.setCapacity(course.getCapacity());
        }
        if (course.getLocation() != null) {
            existingCourse.setLocation(course.getLocation());
        }

        // Save the updated course entity
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }
    
    public int findMaxCapacityByCourseId(Long courseId) {
        return courseRepository.findMaxCapacityByCourseId(courseId);
    }
    
    public List<Course> findbyTeacherId(Long teacherId)
    {
    	return courseRepository.findByTeacherId(teacherId);
    }
}

