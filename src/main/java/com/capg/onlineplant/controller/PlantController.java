package com.capg.onlineplant.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlineplant.entity.Plant;
import com.capg.onlineplant.exception.PlantIdNotFoundException;
import com.capg.onlineplant.service.PlantService;
/*Controller Class for Plant Controller
Author : Lavanya
Date Created : 29/11/2021
*/
@RestController
//Request Mapping tells what URL will initiate what method
@RequestMapping("/plants")
@CrossOrigin("http://localhost:4200")
public class PlantController {	

	@Autowired
    PlantService plantService;
	/****************************
	 * Method: addPlant 
	 * Description: It is used to add into the plant table 
	 * @returns plant It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Lavanya
     *Created Date - 29 -11-2021 
	 * 
	 ****************************/
	@PostMapping("/addPlant")
	public ResponseEntity<Plant> addPlant(@RequestBody Plant plant) {
		plantService.addPlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.CREATED);
	}
	/****************************
	 * Method: Update plant 
	 * Description: It is used to update plant in plant table
	 * @returns plant It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/	
	@PutMapping({"/updatePlant"})
	public ResponseEntity<Plant> updatePlant(@RequestBody Plant plant, @PathVariable int plantId) {
		// logger.trace("updating the whole plant having id "+ id);  
		plantService.updatePlant(plant);
		return new ResponseEntity<Plant>(plant, HttpStatus.ACCEPTED);
	}

	/****************************
	 * Method: removePlant
	 * Description: It is used to remove the items in the plant table
	 * @returns plant It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Lavanya
     *Created Date - 29 -11-2021 
	 * 
	 ****************************/
	@DeleteMapping("/removePlant")
	public ResponseEntity<Plant> removePlant(@PathVariable Plant plantId) throws PlantIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<Plant>(plantService.removePlant(plantId), HttpStatus.OK);
	}

	
	/****************************
	 * Method: viewAllplant
	 * Description: It is used to view all order items in plant table
	 * @returns plant It returns plant with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getAll")
	public ResponseEntity<List<Plant>> viewAllPlants() {
		//logger.trace("fetching all the plants");
		List<Plant> list = plantService.viewAllPlants();
		return new ResponseEntity<List<Plant>>(list, HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllplant 
	 * Description: It is used to view all plant items in plant table
	 * @returns plant It returns order with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getPlants/typeOfPlant/{typeOfPlant}")
	public ResponseEntity<List<Plant>> viewAllPlants(@PathVariable String typeOfPlant) {
		//logger.trace("searching the plants of type "+typeOfPlant);
		List<Plant> list = plantService.viewAllPlants();
		return new ResponseEntity<List<Plant>>(list,HttpStatus.OK);
	}

}
