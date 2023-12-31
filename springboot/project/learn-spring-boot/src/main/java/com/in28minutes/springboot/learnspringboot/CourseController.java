package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//http://localhost:8080/courses
//[
// {
//	 "id" : 1,
//	 "name" : "Learn AWS",
//	 "author" : "in28minutes"
// }
//]
		
@RestController
public class CourseController {

	@RequestMapping("/courses")
	public List<Course> retrieveAllCourses() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "in28minutes"),
				new Course(2, "Learn DepOps", "in28minutes"),
				new Course(3, "Learn Azure", "in28minutes"),
				new Course(6, "Learn Azure", "in28minutes")
				);
	}
	
}
