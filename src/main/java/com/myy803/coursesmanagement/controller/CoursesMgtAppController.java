package com.myy803.coursesmanagement.controller;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.myy803.coursesmanagement.model.Course;
import com.myy803.coursesmanagement.model.StudentRegistration;
import com.myy803.coursesmanagement.service.CourseService;
import com.myy803.coursesmanagement.service.StudentRegistrationService;
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

@Controller
public class CoursesMgtAppController {
	
	private CourseService courseService;
	private StudentRegistrationService registrationService;
	
	
	public CoursesMgtAppController(CourseService courseService, StudentRegistrationService registrationService) {
		super();
		this.courseService = courseService;
		this.registrationService = registrationService;
	}
	
	@GetMapping("/")
	public String startPage() {
		
		return "redirect:/courses";
	}

	//------------------------------------------------------------------------//
	//------------------------------- Courses --------------------------------//
	//------------------------------------------------------------------------//
	
	@GetMapping("/courses")
	public String courses(Model model) {
		
		String teacherUsername = SecurityContextHolder.getContext().getAuthentication().getName();

		model.addAttribute("courses", courseService.findCourseByInstructorLogin(teacherUsername));
		
		return "courses";
	}
	
	@GetMapping("/courses/new")
	public String createCourseForm(Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		
		return "new-course";
	}
	
	@PostMapping("/courses/new")
	public String createCourse(@ModelAttribute("course") Course course) {
		
		course.setTeacher(SecurityContextHolder.getContext().getAuthentication().getName());
		courseService.save(course);
		
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{id}/delete")
	public String deleteCourse(@PathVariable int id) {
		
		courseService.delete(id);
		
		return "redirect:/courses";
	}
	
	@GetMapping("/courses/{id}/edit")
	public String updateCourseForm(@PathVariable int id, Model model) {
		
		model.addAttribute("course", courseService.getCourseById(id));
		
		return "update-course";
	}

	@PostMapping("/courses/{id}/edit")
	public String updateCourse(@PathVariable int id,
							   @ModelAttribute("course") Course course,
							   Model model) {
					
		courseService.update(course);
		return "redirect:/courses";
	}
	
	//------------------------------------------------------------------------//
	//------------------------------- Students -------------------------------//
	//------------------------------------------------------------------------//
	
	@GetMapping("/courses/{id}/students")
	public String students(@PathVariable("id") int id, Model model) {
		Course course = courseService.getCourseById(id);
		int course_id = course.getCourse_id();
		
		model.addAttribute("students", registrationService.findRegistrationsByCourseId(course_id));
		model.addAttribute("course_id",	course_id);
		model.addAttribute("projectPercent", courseService.getCourseById(id).getProjectPercent());
		model.addAttribute("examPercent", courseService.getCourseById(id).getExamPercent());
		
		return "students";
	}
	
	@GetMapping("/courses/{c_id}/students/new")
	public String newStudentForm(@PathVariable("c_id") int c_id, Model model) {
		StudentRegistration student = new StudentRegistration();
		
		model.addAttribute("student", student);
		model.addAttribute("c_id", c_id);
		return "new-student";
	}
	
	@PostMapping("/courses/{c_id}/students/new")
	public String createStudent(@PathVariable("c_id") int c_id, 
								@ModelAttribute("student") StudentRegistration student, 
								Model model) {
		model.addAttribute("c_id", c_id);
		
		student.setCourse(courseService.getCourseById(c_id));
		registrationService.save(student);
		return "redirect:/courses/" + c_id + "/students";
	}
	
	@GetMapping("/courses/{id}/students/{st_id}/edit")
	public String editStudentForm(@PathVariable int id, @PathVariable int st_id, Model model) {
		model.addAttribute("student", registrationService.getStudentRegById(st_id));
		model.addAttribute("course_id", id);
		return "update-student";
	}
	
	@PostMapping("/courses/{id}/students/{st_id}/edit")
	public String updateStudent(@PathVariable int id, @PathVariable int st_id, 
								@ModelAttribute("student") StudentRegistration student,
								Model model) {
						
		student.setId(st_id);
		registrationService.update(student);
		return "redirect:/courses/" + id + "/students";	
	}
	
	@GetMapping("/courses/{id}/students/{st_id}/delete")
	public String deleteStudent(@PathVariable int id, @PathVariable int st_id) {
		registrationService.delete(st_id);
		return "redirect:/courses/" + id + "/students";
	}
	
	//------------------------------------------------------------------------//
	//------------------------------ Statistics ------------------------------//
	//------------------------------------------------------------------------//
	
	@GetMapping("/courses/{id}/statistics")
	public String presentStatistics(@PathVariable int id, Model model) {
		
		Course course = courseService.getCourseById(id);
		courseService.setCourse(course);
		
		List<StatisticStrategy> strategies = courseService.getStatCalculationStrategies();
		strategies.add(new MinStatisticStrategy());
		strategies.add(new MaxStatisticStrategy());
		strategies.add(new MeanStatisticStrategy());
		strategies.add(new StandardDeviationStatisticStrategy());
		strategies.add(new VarianceStatisticStrategy());
		strategies.add(new PercentilesStatisticStrategy());
		strategies.add(new SkewnessStatisticStrategy());
		strategies.add(new KurtosisStatisticStrategy());
		strategies.add(new MedianStatisticStrategy());
		courseService.setStatCalculationStrategies(strategies);
		
		model.addAttribute("statistics", courseService.getCourseStatistics());
		
		return "statistics";
	}
	
}
