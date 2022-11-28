package com.myy803.coursesmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myy803.coursesmanagement.dao.StudentRegistrationDAO;
import com.myy803.coursesmanagement.model.StudentRegistration;

@Service
public class StudentRegistrationServiceImpl implements StudentRegistrationService {
	
	@Autowired
	private StudentRegistrationDAO studentRegDAO;
	
	public StudentRegistrationServiceImpl() {
		
	}
	
	public StudentRegistrationServiceImpl(StudentRegistrationDAO studentRegDAO) {
		super();
		this.studentRegDAO = studentRegDAO;
	}
	
	@Override
	public List<StudentRegistration> findRegistrationsByCourseId(int id) {
		return studentRegDAO.findRegistrationsByCourseId(id);
	}

	@Override
	public void delete(int id) {
		studentRegDAO.delete(id);
	}

	@Override
	public void save(StudentRegistration studentReg) {
		studentRegDAO.save(studentReg);
	}

	@Override
	public void update(StudentRegistration studentReg) {
		StudentRegistration existingStudent = getStudentRegById(studentReg.getId());
		
		existingStudent.setFirstName(studentReg.getFirstName());
		existingStudent.setLastName(studentReg.getLastName());
		existingStudent.setAm(studentReg.getAm());
		existingStudent.setEmail(studentReg.getEmail());
		existingStudent.setRegistrationYear(studentReg.getRegistrationYear());
		existingStudent.setSemester(studentReg.getSemester());
		existingStudent.setProjectGrade(studentReg.getProjectGrade());
		existingStudent.setExamGrade(studentReg.getExamGrade());
		
		studentRegDAO.update(existingStudent);
	}
	
	@Override
	public StudentRegistration getStudentRegById(int id) {
		return studentRegDAO.getStudentRegById(id);
	}

}
