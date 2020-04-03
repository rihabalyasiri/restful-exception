package com.example.Restproject;
//package jackson;
//
import java.io.File;
import java.io.IOException;

import com.example.Restproject.entity.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
//
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
	
			//create object mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			//read json file and map to POJO 
			
			Student student;
			try {
				student = objectMapper.readValue(new File("data/sample.json"), Student.class);
			
				System.out.print(student.getFirstName()+ " " + student.getLastName());
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//print data
			
		
	}

}
