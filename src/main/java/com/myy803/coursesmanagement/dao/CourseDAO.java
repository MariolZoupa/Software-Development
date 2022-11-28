package com.myy803.coursesmanagement.dao;

import java.util.List;

import com.myy803.coursesmanagement.model.Course;

public interface CourseDAO {
	
	List<Course> findCourseByInstructorLogin(String login);
	
	void delete(int id);
	
	void save(Course course);
	
	void update(Course course);
	
	Course getCourseById(int id);

}
