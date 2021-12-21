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
import com.capg.onlineplant.entity.Customer;
import com.capg.onlineplant.exception.CustomerIdNotFoundException;
import com.capg.onlineplant.service.CustomerService;

/*Controller Class for Customer Controller
Author : Khyathy.V
Date Created : 29/11/2021
*/
@RestController
//Request Mapping tells what URL will initiate what method
@RequestMapping("/customers")
@CrossOrigin("http://localhost:4200")
public class CustomerController {
@Autowired
  CustomerService service;
	
/****************************
 * Method: addCustomers 
 * Description: It is used to add into the customers table 
 * @returns customers It returns String type message
 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
 * Created By-khyathy.v
 *Created Date -  29-11-2021 
 * 
 ****************************/
	@PostMapping(path="/addCustomer")
	public ResponseEntity<Boolean> addCustomer(@RequestBody Customer customer) {
		service.addCustomer(customer);
		
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	} 
	

	/****************************
	 * Method: Update customers 
	 * Description: It is used to update customers in customers table
	 * @returns customers It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-khyathy.v
     *Created Date -  29-11-2021 
	 * 
	 ****************************/	

	@PutMapping(path="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){
		customer=service.updateCustomer(customer);
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	/****************************
	 * Method: removeCustomer
	 * Description: It is used to remove the items in the customer table
	 * @returns customer It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By khyathy.v
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@DeleteMapping(path="/removeCustomer")
	public String removeCustomer(@PathVariable("customer") Customer customer) {
		service.removeCustomer(customer);
		return "Deleted";
	}
	/****************************
	 * Method: getAllCustomer
	 * Description: It is used to get All Customer items in Customer table
	 * @returns Customer It returns Customer  with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By khyathy.V
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping(path="/getAll")
	public  ResponseEntity<List<Customer>> getAll(){
		List<Customer> list=service.viewAllCustomers();
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	
	}
	/****************************
	 * Method: view Customer
	 * Description: It is used to view Customer items in Customer table
	 * @returns Customer It returns Customer with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By khyathy.v
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping(path="/viewCustomer/{customerId}")
	public  ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") int customerId){
		Customer customer=service.viewCustomer(customerId);
		if(customer == null) {
			throw new CustomerIdNotFoundException("Customer not found for id="+customerId);
		}
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	}
	/****************************
	 * Method: validate Customer
	 * Description: It is used to validate into Customer table
	 * @returns Customer It returns Customer with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By khyathy.V
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping(path= "/validateCustomer/{username}/{password}")
	public ResponseEntity<Customer> validateCustomer(@PathVariable String username ,@PathVariable String password) 
	{
		Customer customer=service.validateCustomer(username,password);
		
		return new ResponseEntity<Customer>(customer,HttpStatus.OK);	
	}
	
}







