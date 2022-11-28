package com.myy803.coursesmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_registrations")
public class StudentRegistration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "am", unique = true, nullable = false)
	private int am;
	
	@Column(name = "registration_year", nullable = false)
	private int registrationYear;
	
	@Column(name = "semester", nullable = false)
	private int semester;
	
	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)	
	private Course course;
	
	@Column(name = "project_grade")
	private Double projectGrade = 0d;
	
	@Column(name = "exam_grade")
	private Double examGrade = 0d;
	
	
	public StudentRegistration() {
		
	}
		
	public StudentRegistration(String firstName, String lastName, String email, int am, int registrationYear,
			int semester, Course course, Double projectGrade, Double examGrade) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.am = am;
		this.registrationYear = registrationYear;
		this.semester = semester;
		this.course = course;
		this.projectGrade = projectGrade;
		this.examGrade = examGrade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public int getAm() {
		return am;
	}

	public void setAm(int am) {
		this.am = am;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Double getProjectGrade() {
		return projectGrade;
	}


	public void setProjectGrade(Double projectGrade) {
		this.projectGrade = projectGrade;
	}


	public Double getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(Double examGrade) {
		this.examGrade = examGrade;
	}

	public int getRegistrationYear() {
		return registrationYear;
	}

	public void setRegistrationYear(int registrationYear) {
		this.registrationYear = registrationYear;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
