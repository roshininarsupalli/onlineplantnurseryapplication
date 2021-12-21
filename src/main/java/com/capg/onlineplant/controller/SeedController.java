package com.capg.onlineplant.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
import com.capg.onlineplant.entity.Seed;
import com.capg.onlineplant.exception.SeedIdNotFoundException;
import com.capg.onlineplant.service.SeedService;

/*Controller Class for Seed Controller
Author : Saumya Pancholi
Date Created : 29/11/2021
*/

@RestController
//Request Mapping tells what URL will initiate what method
@RequestMapping("/seeds")
@CrossOrigin("http://localhost:4200")
public class SeedController {	

	@Autowired
    SeedService seedService;
	/****************************
	 * Method: addseed 
	 * Description: It is used to add into the seed table 
	 * @returns seed It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Saumya Pancholi
     *Created Date -  29-11-2021 	  
	 ****************************/
	@PostMapping("/addSeed")
	public ResponseEntity<Seed> addSeed(@RequestBody Seed seed) {
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed, HttpStatus.CREATED);
	}
	/****************************
	 * Method: Update seed 
	 * Description: It is used to update  in seed table
	 * @returns seed It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By-Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/	
	@PutMapping({"/updateSeed"})
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed) {
		seedService.updateSeed(seed);
		return new ResponseEntity<Seed>(seed, HttpStatus.ACCEPTED);
	}
	/****************************
	 * Method: removeSeed
	 * Description: It is used to remove the items in the Seed table
	 * @returns Seed It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@DeleteMapping("/removeSeed")
	public ResponseEntity<Seed> removeSeed(@PathVariable Seed seed) throws SeedIdNotFoundException{
		//logger.trace("deleting the whole plant");	
		return new ResponseEntity<Seed>(seedService.removeSeed(seed), HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllSeed
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getAll")
	public ResponseEntity<List<Seed>> viewAllSeeds() {
		//logger.trace("fetching all the plants");
		List<Seed> list = seedService.viewAllSeeds();
		return new ResponseEntity<List<Seed>>(list, HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllSeed by type of seeds
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping(path="/getSeeds/typeOfSeeds/{typeOfSeed}")
	public ResponseEntity<List<Seed>> viewAllSeeds(@PathVariable String typeOfSeed) {
		//logger.trace("searching the plants of type "+typeOfPlant);
		List<Seed>list= seedService.viewAllSeeds();
		return new ResponseEntity<List<Seed>>(list,HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllSeed by SeedId
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getSeeds/{seedId}")
	public ResponseEntity<Seed> viewSeed(@PathVariable("seedId") int seedId) {
		seedService.viewSeed(seedId);
		return new ResponseEntity<Seed>(HttpStatus.OK);
	}
	/****************************
	 * Method: viewAllSeed by common name
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * Created By Saumya Pancholi
     *Created Date -  29-11-2021 
	 * 
	 ****************************/
	@GetMapping("/getSeeds/commonName/{commonName}")
	public ResponseEntity<Seed> findBycommonName(@PathVariable("commonName") String commonName) {
		Optional<Seed> se = seedService.findBycommonName(commonName);
		if (se == null) {
			throw new SeedIdNotFoundException("seed not found for name=" + commonName);
		}
		return new ResponseEntity<Seed>(new HttpHeaders(), HttpStatus.OK);
	}



}

