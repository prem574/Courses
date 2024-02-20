package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	 int findMaxCapacityByCourseId(Long courseId);
	 @Query("SELECT c FROM Course c WHERE c.teacher.teacherId = :teacherId")
	 List<Course> findByTeacherId(@Param("teacherId") Long teacherId);

}
