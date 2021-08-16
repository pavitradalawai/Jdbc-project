package com.xworkz.customer.testers;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.constant.Education;
import com.xworkz.customer.customenum.EducationType;
import com.xworkz.customer.dao.CustomerDAO;

import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.service.CustomerService;
import com.xworkz.customer.service.CustomerServiceImpl;

public class CustomerTester {

	public static void main(String[] args) {
		CustomerDTO dto = new CustomerDTO("Ram", "jkd", "mudhol", "Basava Circle", false, "abc123", Education.BE);
		CustomerDTO dto1 = new CustomerDTO("Sham", "bgk", "jkd", "laxmi Circle", false, "xyz546", Education.BCOM);

		CustomerService dao = new CustomerServiceImpl();
		dao.validateAndSave(dto);
		dao.validateAndSave(dto1);
		Collection<CustomerDTO> collect = Arrays.asList(dto, dto1);
		dao.validateAndSaveAll(collect);
		System.out.println("##");

		Optional<CustomerDTO> one = dao.findOne(d -> d.getName().equals("Ram"));
		if (one.isPresent()) {
			CustomerDTO name = one.get();
			System.out.println(name);
		}

		Collection<CustomerDTO> all = dao.findAll();
		all.forEach(t -> System.out.println(t));
		System.out.println("##");

		Collection<CustomerDTO> findAll = dao.findAll(g -> g.getId() == 20);
		findAll.forEach(g -> System.out.println(g));
		System.out.println("##");

		Collection<CustomerDTO> byName = dao.findAllSortByNameDesc();
		byName.forEach(f -> System.out.println(f));
		int total = dao.total();
		System.out.println(total);
	}
}
