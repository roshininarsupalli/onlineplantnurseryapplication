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
import com.capg.onlineplant.entity.Planter;
import com.capg.onlineplant.exception.PlanterIdNotFoundException;
import com.capg.onlineplant.service.PlanterService;
/*Controller Class for Planter Controller
Author : Roshini Narsupalli
Date Created : 29/11/2021
*/
@RestController
//Request Mapping tells what URL will initiate what method
@RequestMapping("/planters")
@CrossOrigin("http://localhost:4200")
public class PlanterController {	

	@Autowired
    PlanterService planterService;
	/****************************
	 * Method: addPlanter 
	 * Description: It is used to add into the planter table 
	 * @returns planter It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Roshini Narsupalli
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@PostMapping("/addPlanter")
	public ResponseEntity<Planter> addPlanter(@RequestBody Planter planter) {
		planterService.addPlanter(planter);
		return new ResponseEntity<Planter>(planter, HttpStatus.CREATED);
	}
	/****************************
	 * Method: Update planter 
	 * Description: It is used to update planter in planter table
	 * @returns planter It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Roshini Narsupalli
     *Created Date - 29 -11-2021 
	 * 
	 ****************************/	
	
	@PutMapping({"/updateplanter"})
	public ResponseEntity<Planter> updatePlanter(@RequestBody Planter planter, @PathVariable int planterId) {
		// logger.trace("updating the whole plant having id "+ id);  
		planterService.updatePlanter(planter);
		return new ResponseEntity<Planter>(planter, HttpStatus.ACCEPTED);
	}

	
	/****************************
	 * Method: removePlanter
	 * Description: It is used to remove the items in the planter table
	 * @returns planter It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Roshini Narsupalli
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@DeleteMapping("/removeplanter")
	public ResponseEntity<Planter> removePlanter(@PathVariable Planter planterId) throws PlanterIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<Planter>(planterService.removePlanter(planterId), HttpStatus.OK);
	}

	
	/****************************
	 * Method: viewAllplanter
	 * Description: It is used to view all planter items in planter table
	 * @returns planter It returns plant with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Roshini Narsupalli
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getAll")
	public ResponseEntity<List<Planter>> viewAllPlanters() {
		//logger.trace("fetching all the plants");
		List<Planter> list = planterService.viewAllPlanters();
		return new ResponseEntity<List<Planter>>(list, HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllplanter
	 * Description: It is used to view all order items in planter table
	 * @returns planter It returns planter with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Roshini Narsupalli
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getPlanters/planterShape/{planterShape}")
	public ResponseEntity<List<Planter>> viewAllPlanters(@PathVariable String planterShape) {
		//logger.trace("searching the plants of type "+typeOfPlant);
		List<Planter> list = planterService.viewAllPlanters();
		return new ResponseEntity<List<Planter>>(list,HttpStatus.OK);
	}
}
