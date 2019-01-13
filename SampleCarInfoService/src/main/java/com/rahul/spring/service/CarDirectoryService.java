package com.rahul.spring.service;

import com.rahul.spring.pojo.CarDetails;

public interface CarDirectoryService {
	
	public String addCarDetails(String registrationNumber, String model, String manufacturerName, String manufacturingYear);
	public CarDetails searchCarInfo(String empName);
}
