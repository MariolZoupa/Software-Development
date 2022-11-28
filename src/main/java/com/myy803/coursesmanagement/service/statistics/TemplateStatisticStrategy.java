package com.myy803.coursesmanagement.service.statistics;

import com.myy803.coursesmanagement.model.Course;
import com.myy803.coursesmanagement.model.StudentRegistration;

public abstract class TemplateStatisticStrategy implements StatisticStrategy {
	
	private Course course;
	private double [] finalGrades;
	private double statisticNum;
	
	public TemplateStatisticStrategy() {
		
	}
	
	@Override
	public double calculateStatistic(Course givenCcourse) {
		this.course = givenCcourse;
		prepareDataSet();
		
		doActualCalculation();
		
		return statisticNum;
	}
	
	private void prepareDataSet() {
		
		if(course.getStudentRegistrations().isEmpty()) {
			System.out.println("Empty registrations");
			return;
		}

		finalGrades = new double[course.getStudentRegistrations().size()];
		int i = 0;
				
		for (StudentRegistration student: course.getStudentRegistrations()) {
			finalGrades[i] = student.getProjectGrade()*course.getProjectPercent() + student.getExamGrade()*course.getExamPercent();
			i++;
		}
	}
	
	public abstract void doActualCalculation();

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public double[] getFinalGrades() {
		return this.finalGrades;
	}

	public double getStatisticNum() {
		return statisticNum;
	}

	public void setStatisticNum(double statisticNum) {
		this.statisticNum = statisticNum;
	}
	
	

}
