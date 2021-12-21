package com.capg.onlineplant;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.onlineplant.dao.CustomerDao;
import com.capg.onlineplant.entity.Customer;

import com.capg.onlineplant.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	@InjectMocks
    private CustomerServiceImpl customerService;
	
	@Mock
	private CustomerDao dao;
	
	@Test
	public void addCustomerTest() {
		Customer customer = new Customer();
		customer.setCustomerId(2);
		Mockito.when(dao.addCustomer(customer)).thenReturn(customer);
		//assertEquals(customer, service.addCustomer(customer));
	}	

}

