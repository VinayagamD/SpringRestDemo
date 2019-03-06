package com.vinay.jackson.json.demo;

import java.io.File;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
//			create object mapper
			ObjectMapper mapper = new ObjectMapper();
//			read JSON file and map/convert to Java POJO : 
			
//			data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
//			print the first name  and last name
			System.out.println("First Name = " + student.getFirstName());
			System.out.println("Last Name = " + student.getLastName());
			
//			print out address : street and city
			Address  address = student.getAddress();
			
			System.out.println("Street = " +address.getStreet());
			System.out.println("City = " +address.getCity());
			
//			Languages
			Arrays.asList(student.getLanguages()).forEach(l -> System.out.println(l)); 
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
