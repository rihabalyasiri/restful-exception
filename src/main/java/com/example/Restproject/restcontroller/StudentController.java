package com.example.Restproject.restcontroller;

import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restproject.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private ArrayList<Student> studList;
	
	@PostConstruct
	public void loadData() {
		studList = new ArrayList<Student>();
		studList.add(new Student("rihab","alyasiri"));
		studList.add(new Student("vanessa","vaksmann"));
		studList.add(new Student("jakob","vaksmann"));
	}
	
	@GetMapping("/students")
	public ArrayList<Student> getStudents() {

		return studList;
		
	}
	
	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentId >= studList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return studList.get(studentId);
	}
	
	
}











