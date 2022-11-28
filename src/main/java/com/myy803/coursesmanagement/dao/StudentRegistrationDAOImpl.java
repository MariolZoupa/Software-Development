package com.myy803.coursesmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myy803.coursesmanagement.model.StudentRegistration;

@Repository
public class StudentRegistrationDAOImpl implements StudentRegistrationDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<StudentRegistration> findRegistrationsByCourseId(int id) {
		
		String sql_query = "SELECT reg "
					+ "FROM Course c, StudentRegistration reg "
					+ "WHERE c.course_id = reg.course.course_id AND reg.course.course_id = " + id;
		
		TypedQuery<StudentRegistration> query = entityManager.createQuery(sql_query, StudentRegistration.class);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void delete(int id) {
	    StudentRegistration studentReg = entityManager.find(StudentRegistration.class, id);
	    entityManager.remove(studentReg);
	}

	@Override
	@Transactional
	public void save(StudentRegistration studentReg) {
		
		String sql_query = "SELECT reg "
		 		+ "FROM StudentRegistration reg "
		 		+ "WHERE reg.am = " + studentReg.getAm();

		TypedQuery<StudentRegistration> query = entityManager.createQuery(sql_query, StudentRegistration.class);
		if (query.getResultList().isEmpty()) {
				entityManager.persist(studentReg);
		}
		else {
			System.out.println("This student id already exists");
		}

				
	}

	@Override
	@Transactional
	public void update(StudentRegistration studentReg) {
		entityManager.merge(studentReg);
	}

	@Override
	@Transactional
	public StudentRegistration getStudentRegById(int id) {
		return entityManager.find(StudentRegistration.class, id);
	}

}
