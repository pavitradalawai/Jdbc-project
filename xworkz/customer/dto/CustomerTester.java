package com.xworkx.customer.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.xworkx.customer.dto.constants.Education;
import com.xworkx.customer.service.CustomerService;
import com.xworkx.customer.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {

		CustomerDTO dto = new CustomerDTO("Ram", "Jkd", "Bgk", "Basava Nagar" , "married", "xyz4567",
				Education.BE);

		CustomerDTO dto1 = new CustomerDTO("Sham", "Bgk", "Jkd", "Lakshmi nagar", "funmarried", "abc9876",
				Education.BSC);

		

		CustomerService customerservice = new CustomerServiceImpl();
		customerservice.validateAndSave(dto);
		customerservice.validateAndSave(dto1);
		
		
		
		Collection<CustomerDTO> cl = Arrays.asList(dto, dto1 );
		customerservice.validateAndSaveAll(cl);
		cl.forEach(o->System.out.println(o));
		
		Optional<CustomerDTO> findOne = customerservice.findOne(a -> a.getName().equalsIgnoreCase("ram"));
		if (findOne.isPresent()) {
			CustomerDTO name = findOne.get();
			System.out.println(name);
		}
	

		Optional<CustomerDTO> findOne1 = customerservice.findOne(m -> m.getName().equalsIgnoreCase("ram"));
		if (findOne1.isPresent()) {
			CustomerDTO name = findOne1.get();
			System.out.println(name);
		}
		
		Collection<CustomerDTO> findAll = customerservice.findAll();
		findAll.forEach(b -> System.out.println(b));
		
		
		Collection<CustomerDTO> findall = customerservice.findAll(o -> o.getFrom().endsWith("m"));
		findall.forEach(k -> System.out.println(k));
		
		
		Collection<CustomerDTO> nameDesc = customerservice.findAllSortByNameDesc();
		nameDesc.forEach(p -> System.out.println(p));
		
		
		int total = customerservice.total();
		System.out.println(total);
		

	}
}


