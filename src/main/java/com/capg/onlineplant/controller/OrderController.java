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
import com.capg.onlineplant.entity.Order;
import com.capg.onlineplant.exception.OrderIdNotFoundException;
import com.capg.onlineplant.service.OrderService;

	/*Controller Class for Order Controller
	Author : Roshini Narsupalli
	Date Created : 29/11/2021
	*/

	@RestController
	//Request Mapping tells what URL will initiate what method
	@RequestMapping("/orders")
	@CrossOrigin("http://localhost:4200")
	public class OrderController {	

		@Autowired
	    OrderService orderService;
		/****************************
		 * Method: addOrder 
		 * Description: It is used to add into the order table 
		 * @returns order It returns String type message
		 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * Created By-Roshini Narsupalli
	     *Created Date -  29-11-2021 
		 * 
		 ****************************/
		@PostMapping("/addOrder")
		public ResponseEntity<Order> addOrder(@RequestBody Order order) {
			orderService.addOrder(order);
			return new ResponseEntity<Order>(order, HttpStatus.CREATED);
		}
		/****************************
		 * Method: Update customers 
		 * Description: It is used to update customers in customers table
		 * @returns customers It returns String type message 
		 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * Created By- Roshini Narsupalli
	     *Created Date -  29-11-2021 
		 ****************************/	
		@PutMapping({"/updateorder"})
		public ResponseEntity<Order> updateOrdter(@RequestBody Order order , @PathVariable int orderId) {
			// logger.trace("updating the whole plant having id "+ id);  
			orderService.updateOrder(order);
			return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
		}
		/****************************
		 * Method: removeOrder
		 * Description: It is used to remove the items in the order table
		 * @returns order It returns String type message 
		 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
		 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * Created By Roshini Narsupalli
	     *Created Date -  29-11-2021 
		 * 
		 ****************************/

		@DeleteMapping("/deleteorder")
		public ResponseEntity<Order> deleteOrder(@PathVariable int orderId) throws OrderIdNotFoundException{
			//logger.trace("deleting the whole plant");	
			return new ResponseEntity<Order>(orderService.deleteOrder(orderId), HttpStatus.OK);
		}
		/****************************
		 * Method: viewAllOrder 
		 * Description: It is used to view all order items in order table
		 * @returns order It returns order with details
		 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * Created By Roshini Narsupalli
	     *Created Date -  29-11-2021 
		 * 
		 ****************************/
		@GetMapping("/getAll")
		public ResponseEntity<List<Order>> viewAllOrders() {
			//logger.trace("fetching all the plants");
			List<Order> list = orderService.viewAllOrders();
			return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
		}
		/****************************
		 * Method: viewAllOrder by id 
		 * Description: It is used to view all order items in order table
		 * @returns order It returns order with details
		 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
		 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
		 * Created By Roshini Narsupalli
	     *Created Date -  29-11-2021 
		 * 
		 ****************************/
		@GetMapping("/getOrders/orderId/{orderId}")
		public ResponseEntity<List<Order>> viewAllOrders(@PathVariable int OrderId) {
			//logger.trace("searching the plants of type "+typeOfPlant);
			List<Order> list = orderService.viewAllOrders();
			return new ResponseEntity<List<Order>>(list,HttpStatus.OK);
		}
	}