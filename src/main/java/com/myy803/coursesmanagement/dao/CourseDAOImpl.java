package com.myy803.coursesmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myy803.coursesmanagement.model.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	@Transactional
	public List<Course> findCourseByInstructorLogin(String login) {

		String sql_query = "SELECT c "
						 + "FROM Course c "
						 + "WHERE c.teacher = '" + login + "'";
		
		TypedQuery<Course> query = entityManager.createQuery(sql_query, Course.class);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void delete(int id) {
	    Course course = entityManager.find(Course.class, id);
	    entityManager.remove(course);
	}

	@Override
	@Transactional
	public void save(Course course) {
		entityManager.persist(course);
	}

	@Override
	@Transactional
	public void update(Course course) {	    
	    entityManager.merge(course);
	}
	
	@Override
	@Transactional
	public Course getCourseById(int id) {
		return entityManager.find(Course.class, id);
	}

}
