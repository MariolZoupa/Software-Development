package com.myy803.coursesmanagement.service;

import java.util.List;

import com.myy803.coursesmanagement.model.StudentRegistration;

public interface StudentRegistrationService {
	
	List<StudentRegistration> findRegistrationsByCourseId(int id);
	
	void delete(int id);
	
	void save(StudentRegistration studentReg);
	
	void update(StudentRegistration studentReg);
	
	StudentRegistration getStudentRegById(int id);
}
