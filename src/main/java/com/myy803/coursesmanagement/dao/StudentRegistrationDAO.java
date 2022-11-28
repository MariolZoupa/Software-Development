package com.myy803.coursesmanagement.dao;

import java.util.List;

import com.myy803.coursesmanagement.model.StudentRegistration;

public interface StudentRegistrationDAO {
	
	List<StudentRegistration> findRegistrationsByCourseId(int id);
	
	void delete(int id);
	
	void save(StudentRegistration studentReg);
	
	void update(StudentRegistration studentReg);
	
	StudentRegistration getStudentRegById(int id);
}
