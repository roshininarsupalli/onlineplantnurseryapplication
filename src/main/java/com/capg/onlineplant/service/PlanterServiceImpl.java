package com.capg.onlineplant.service;
	import java.util.List;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

import com.capg.onlineplant.dao.PlanterDao;
import com.capg.onlineplant.entity.Planter;
/*
 * Author : Roshini Narsupalli
 * Version : 1.0
 * Date : 28-11-2021
 * Description : This is planter Service
*/
	@Transactional
	@Service
	public class PlanterServiceImpl implements PlanterService{
		
		@Autowired
		private PlanterDao planterRepo;
		 /************************************************************************************
		 * Method: viewAllPlanters
		 * Description: It is used to view into planter table
		 * @param : planter reference variable.
		 * @returns  It returns planter with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Roshini Narsupalli
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
		@Override
		public List<Planter> viewAllPlanters() {
			return planterRepo.viewAllPlanters();
		}
		 /************************************************************************************
		 * Method: view planter
		 * Description: It is used to view into planter table
		 * @param : planter reference variable.
		 * @returns  It returns planter with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Roshini Narsupalli
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
		@Override
		public Planter viewPlanter(int planterId) {
			return planterRepo.viewPlanter(planterId);
		}

		 /************************************************************************************
			 * Method: addPlanter
			 * Description: It is used to add into planter table
			 * @param : planter reference variable.
			 * @returns  It returns cart with details
			 * @Override: It is used to override the Service methods with DAO implementation.
			 * Created By-Roshini Narsupalli
		     * Created Date -28-11-2021
			 * 
			 ************************************************************************************/
		@Override
		public Planter addPlanter(Planter planter) {
			Planter addplanter = new Planter();
			addplanter.setPlanterheight(planter.getPlanterheight());
			addplanter.setPlanterCapacity(planter.getPlanterCapacity());
			addplanter.setPlanterCost(planter.getPlanterCost());
			addplanter.setPlanterColor(planter.getPlanterColor());
			addplanter.setDrinageHoles(planter.getDrinageHoles());
			addplanter.setPlanterShape(planter.getPlanterShape());
			addplanter.setPlanterStock(planter.getPlanterStock());
			return planterRepo.addPlanter(planter);
		}
		 /************************************************************************************
		 * Method: updatePlanter
		 * Description: It is used to update into Planter table
		 * @param : planter reference variable.
		 * @returns  It returns planter with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Roshini Narsupalli
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
		@Override
		public Planter updatePlanter(Planter planter) {
				return planterRepo.updatePlanter(planter);

			}
		 /************************************************************************************
		 * Method: removePlanter
		 * Description: It is used to remove from Planter table
		 * @param : Planter reference variable.
		 * @returns  It returns Planter with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Roshini Narsupalli
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
		@Override
		public Planter removePlanter(Planter planter) {
			return planterRepo.removePlanter(planter);
		}
		 /************************************************************************************
		 * Method: view Planter by planterShape
		 * Description: It is used to view into Planter table
		 * @param : Planter reference variable.
		 * @returns  It returns Planter with details
		 * @Override: It is used to override the Service methods with DAO implementation.
		 * Created By-Roshini Narsupalli
	     * Created Date -28-11-2021
		 * 
		 ************************************************************************************/
		@Override
		public Planter viewPlanter(String planterShape) {
			return planterRepo.viewPlanter(planterShape);
		}
	}
