package com.vinay.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinay.springrest.entity.Student;
import com.vinay.springrest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students;

//	define @PostConstructto load the students data ... only once!

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();

		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));
	}

	// define endpoint for "/students" return list of students
	@GetMapping("/students")
	public List<Student> students() {
		return students;
	}

	//	define endpoint for "/student/{studentId} - return student at index
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable("studentId") int studentId) {
//		just index into the list... keep it simple for now
		
//		check the studentId against the list
		if((studentId >= students.size())||(studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - " +  studentId);
		}
		
		return students.get(studentId);
	}
	
	
}
