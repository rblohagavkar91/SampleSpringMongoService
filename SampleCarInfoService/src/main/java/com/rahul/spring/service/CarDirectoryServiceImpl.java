package com.rahul.spring.service;

import org.springframework.stereotype.Service;
import com.rahul.spring.controller.SpringDataMongoDB;
import com.rahul.spring.pojo.CarDetails;

@Service
public class CarDirectoryServiceImpl implements CarDirectoryService{

	public static final String SUCCESS = "Record has been successfully updated.";
	public static final String FAILURE = "Record has been failed to update.";
	SpringDataMongoDB db = new SpringDataMongoDB();

	public CarDetails searchCarInfo(String key) {
		System.out.println("Data : "+key.length()+"===="+key.toString());
		CarDetails details = db.searchDetails(key);
		return details;
	}
	public String addCarDetails(String registrationNumber, String model, String manufacturerName,
			String manufacturingYear) {
		boolean response = db.insertDetails(registrationNumber,model,manufacturerName,manufacturingYear);
		if(response) 
			return SUCCESS;
		else
			return FAILURE;
	}
}
