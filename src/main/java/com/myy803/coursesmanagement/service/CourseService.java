package com.myy803.coursesmanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myy803.coursesmanagement.model.Course;
import com.myy803.coursesmanagement.service.statistics.StatisticStrategy;

@Service
public interface CourseService {
	
	List<Course> findCourseByInstructorLogin(String login);
	
	void delete(int id);
	
	void save(Course course);
	
	void update(Course course);
	
	Course getCourseById(int id);
	
	void setCourse(Course course);
	
	Course getCourse();
	
	List<StatisticStrategy> getStatCalculationStrategies();
	
	void setStatCalculationStrategies(List<StatisticStrategy> statCalculationStrategies);
	
	Map<String, Double> getCourseStatistics();
}
