package com.myy803.coursesmanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
	private Set<StudentRegistration> studentRegistrations = new HashSet<>();
	
	@Column(name = "teacher", nullable = false)
	private String teacher;
	
	@Column(name = "course_id", unique = true, nullable = false)
	private int course_id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "syllabus", nullable = false)
	private String syllabus;
	
	@Column(name = "year", nullable = false)
	private int year;
	
	@Column(name = "semester", nullable = false)
	private int semester;
	
	@Column(name = "project_percent", nullable = false)
	private double projectPercent;
	
	@Column(name = "exam_percent", nullable = false)
	private double examPercent;

	
	public Course() {
		
	}


	public Course(Set<StudentRegistration> studentRegistrations, String teacher, int course_id, String name,
			String syllabus, int year, int semester, double projectPercent, double examPercent) {
		super();
		this.studentRegistrations = studentRegistrations;
		this.teacher = teacher;
		this.course_id = course_id;
		this.name = name;
		this.syllabus = syllabus;
		this.year = year;
		this.semester = semester;
		this.projectPercent = projectPercent;
		this.examPercent = examPercent;
	}


	public Set<StudentRegistration> getStudentRegistrations() {
		return studentRegistrations;
	}


	public void setStudentRegistrations(Set<StudentRegistration> studentRegistrations) {
		this.studentRegistrations = studentRegistrations;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	public int getCourse_id() {
		return course_id;
	}


	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getSemester() {
		return semester;
	}


	public void setSemester(int semester) {
		this.semester = semester;
	}


	public double getProjectPercent() {
		return projectPercent;
	}


	public void setProjectPercent(double projectPercent) {
		this.projectPercent = projectPercent;
	}


	public double getExamPercent() {
		return examPercent;
	}


	public void setExamPercent(double examPercent) {
		this.examPercent = examPercent;
	}
	
}
