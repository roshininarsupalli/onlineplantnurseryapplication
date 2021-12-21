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
import com.capg.onlineplant.entity.Cart;
import com.capg.onlineplant.service.CartService;

/*Controller Class for Cart Controller
Author : Lavanya
Date Created : 29/11/2021
*/
@RestController
//Request Mapping tells what URL will initiate what method
@RequestMapping("/cart")
@CrossOrigin("http://localhost:4200")
public class CartController {
	@Autowired
	  CartService serv;
	/****************************
	 * Method: addCart 
	 * Description: It is used to add into the cart table 
	 * @returns cart It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	
	//Create Cart
	@PostMapping(path="/addCart")
	public ResponseEntity<Boolean> addCart(@RequestBody Cart cart) {
		serv.addCart(cart);
		
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	} 
/****************************
	 * Method: Update cart 
	 * Description: It is used to update cart in cart table
	 * @returns cart It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Lavanya
     *Created Date - 29 -11-2021 
	 * 
	 ****************************/	
	//update Cart
	@PutMapping(path="/updateCart")
	public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
		cart=serv.updateCart(cart);
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	/****************************
	 * Method: removeCart
	 * Description: It is used to remove the items in the carts table
	 * @returns cart It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	//Delete Cart
	@DeleteMapping(path="/removeCart")
	public String removeCart(@PathVariable("cart") Cart cart) {
		serv.removeCart(cart);
		return "Deleted";
	}
	/****************************
	 * Method: viewAllCarts 
	 * Description: It is used to view all cart items in carts table
	 * @returns cart It returns Carts with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Lavanya
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	//View All Cart items
	@GetMapping(path="/getAll")
	public  ResponseEntity<List<Cart>> getAll(){
		List<Cart> list=serv.viewAllCarts();
		return new ResponseEntity<List<Cart>>(list,HttpStatus.OK);
	
	}
}
