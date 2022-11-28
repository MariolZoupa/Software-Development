package com.myy803.coursesmanagement.service.statistics;

import com.myy803.coursesmanagement.model.Course;

public interface StatisticStrategy {
	
	double calculateStatistic(Course course);
}
