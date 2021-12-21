package com.capg.onlineplant.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capg.onlineplant.dao.SeedDao;
import com.capg.onlineplant.entity.Seed;
/*
 * Author : Saumya Pancholi
 * Version : 1.0
 * Date : 28-11-2021
 * Description : This is Seed Service
*/
@Transactional
@Service
public class SeedServiceImpl implements SeedService {
	@Autowired
	private SeedDao seedRepo;
	 /************************************************************************************
		 * Method: view by commonname
		 * Description: It is used to view into seed table
		 * @param : seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public Optional<Seed> findBycommonName(String commonName) {
		return seedRepo.findBycommonName(commonName);
	}
	 /************************************************************************************
		 * Method: viewAllSeed
		 * Description: It is used to viewallseed into Seed table
		 * @param : Seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public List<Seed> viewAllSeeds() {
		return seedRepo.viewAllSeeds();
		
	}
	 /************************************************************************************
		 * Method: view seeds by type of seed
		 * Description: It is used to view into Seed table
		 * @param : seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public List<Seed> findBytypeOfSeed(String typeOfSeed) {
		return seedRepo.findBytypeOfSeed(typeOfSeed);
	}

	 /************************************************************************************
		 * Method: addSeed
		 * Description: It is used to add into Seed table
		 * @param : seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public Seed addSeed(Seed seed) {
		Seed addseed = new Seed();
		addseed.setBloomTime(seed.getBloomTime());
		addseed.setCommonName(seed.getCommonName());
		addseed.setSeedsCost(seed.getSeedsCost());
		addseed.setSeedsDescription(seed.getSeedsDescription());
		addseed.setDifficultyLevel(seed.getDifficultyLevel());
		
		addseed.setSeedsPerPacket(seed.getSeedsPerPacket());
		addseed.setWatering(seed.getWatering());
		addseed.setSeedsStock(seed.getSeedsStock());
		addseed.setTemperature(seed.getTemperature());
		addseed.setTypeOfSeeds(seed.getTypeOfSeeds());
		return seedRepo.addSeed(seed);
	}
	 /************************************************************************************
		 * Method: removeSeed
		 * Description: It is used to remove from Seed table
		 * @param : seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/

	@Override
	public Seed removeSeed(Seed seed) {
		return seedRepo.removeSeed(seed);
	}
	 /************************************************************************************
		 * Method: updateSeed
		 * Description: It is used to update into Seed table
		 * @param : Seeds reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public Seed updateSeed(Seed seed) {
		return seedRepo.updateSeed(seed);
	}
	 /************************************************************************************
		 * Method: viewSeed by id
		 * Description: It is used to view into seed table with id
		 * @param : seed reference variable.
		 * @returns  It returns seed with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Saumya Pancholi
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
	@Override
	public Seed viewSeed(int seedId) {
		return seedRepo.viewSeed(seedId);
	}

}
