package com.rahul.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.spring.pojo.CarDetails;
import com.rahul.spring.service.CarDirectoryService;
@RestController
@RequestMapping(value = "/car")
public class CarDirectoryController {
	
	@Autowired
	private CarDirectoryService carService;
	
	/**
	 * Service call for inserting record in MongoDB
	 * @param request
	 * @return string
	 */
	@RequestMapping(value = "/addDetails", method = RequestMethod.POST)
	public String addCarDetails(@RequestBody CarDetails request) {
			String registrationNumber = request.getRegistrationNumber();
            String model = request.getModel();
            String manufacturerName = request.getManufacturerName();
            String manufacturingYear = request.getManufacturingYear();
            System.out.println("Request inputs from service as below");
            System.out.println("Registration Number :"+registrationNumber+" Model :"+model+" Manufacturer Name :"+manufacturerName+" Manufacturing Year :"+manufacturingYear);
			return carService.addCarDetails(registrationNumber,model,manufacturerName,manufacturingYear);
		}
	
	/**
	 * Service call for searching record from MongoDB
	 * @param key(Registration number)
	 * @return 
	 */
	@RequestMapping(value = "/search/{key}", method = RequestMethod.GET)
	public CarDetails searchCarDetails(@PathVariable("key") String key) {
			return carService.searchCarInfo(key);
	}
}
