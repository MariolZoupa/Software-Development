package com.myy803.coursesmanagement.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myy803.coursesmanagement.dao.CourseDAO;
import com.myy803.coursesmanagement.model.Course;
import com.myy803.coursesmanagement.service.statistics.KurtosisStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.MaxStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.MeanStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.MedianStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.MinStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.PercentilesStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.SkewnessStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.StandardDeviationStatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.StatisticStrategy;
import com.myy803.coursesmanagement.service.statistics.VarianceStatisticStrategy;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;
	
	private Course course;
	
	List<StatisticStrategy> statCalculationStrategies = new ArrayList<StatisticStrategy>();
	
	public CourseServiceImpl() {
		
	}
		
	public CourseServiceImpl(CourseDAO courseDAO) {
		super();
		this.courseDAO = courseDAO;
	}

	public Map<String, Double> getCourseStatistics() {
		Map<String, Double> statistics = new HashMap<String, Double>();
		
		if (course == null) {
			return null;
		}
		
		for (StatisticStrategy statistic: statCalculationStrategies) {
			if (statistic instanceof MinStatisticStrategy) {
				statistics.put("Min", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof MaxStatisticStrategy) {
				statistics.put("Max", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof MeanStatisticStrategy) {
				statistics.put("Mean", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof StandardDeviationStatisticStrategy) {
				statistics.put("Standard Deviation", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof VarianceStatisticStrategy) {
				statistics.put("Variance", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof PercentilesStatisticStrategy) {
				statistics.put("Percentiles", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof SkewnessStatisticStrategy) {
				statistics.put("Skewness", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof KurtosisStatisticStrategy) {
				statistics.put("Kurtosis", statistic.calculateStatistic(course));
			}
			else if (statistic instanceof MedianStatisticStrategy) {
				statistics.put("Median", statistic.calculateStatistic(course));
			}
		}
		
		return statistics;
	}
	
	public List<StatisticStrategy> getStatCalculationStrategies() {
		return this.statCalculationStrategies;
	}
	
	public void setStatCalculationStrategies(List<StatisticStrategy> statCalculationStrategies) {
		this.statCalculationStrategies = statCalculationStrategies;
	}
	
	@Override
	public List<Course> findCourseByInstructorLogin(String login) {
		return courseDAO.findCourseByInstructorLogin(login);
	}

	@Override
	public void delete(int id) {
		courseDAO.delete(id);

	}

	@Override
	public void save(Course course) {
		courseDAO.save(course);
	}

	@Override
	public void update(Course course) {
		Course existingCourse = getCourseById(course.getId());
		
		existingCourse.setCourse_id(course.getCourse_id());
		existingCourse.setName(course.getName());
		existingCourse.setSyllabus(course.getSyllabus());
		existingCourse.setYear(course.getYear());
		existingCourse.setSemester(course.getSemester());
		existingCourse.setExamPercent(course.getExamPercent());
		existingCourse.setProjectPercent(course.getProjectPercent());
		
		courseDAO.update(existingCourse);
	}
	
	@Override
	public Course getCourseById(int id) {
		return courseDAO.getCourseById(id);
	}

	@Override 
	public Course getCourse() {
		return course;
	}

	@Override 
	public void setCourse(Course course) {
		this.course = course;
	}

}
