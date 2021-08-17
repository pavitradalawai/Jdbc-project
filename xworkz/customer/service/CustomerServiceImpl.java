package com.xworkx.customer.service;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkx.customer.dto.CustomerDTO;
import com.xworkz.dao.CustomerDAO;
import com.xworkz.dao.CustomerDAOImpl;

public class CustomerServiceImpl implements CustomerService {

	CustomerDAO dao = new CustomerDAOImpl();

	public int validateAndSave(CustomerDTO dto) {

		boolean nameValid = false;
		boolean fromValid = false;
		boolean toValid = false;
		boolean addressValid = false;
		boolean marriedValid = false;
		boolean passportValid = false;
		boolean educationValid = false;

		if (dto != null) {
			System.out.println("validating");
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() >= 3 && name.length() <= 25) {
				System.out.println("name is valid");
				nameValid = true;
			} else {
				System.out.println("name is not valid");
				nameValid = false;
			}

			String fromPlace = dto.getFrom();
			if (fromPlace != null && !fromPlace.isEmpty() && fromPlace.length() >= 4 && fromPlace.length() < 20) {
				System.out.println("from is valid");
				fromValid = true;
			} else {
				System.out.println("from is not valid");
				fromValid = false;
			}

			String toPlace = dto.getTo();
			if (toPlace != null && !toPlace.isEmpty() && toPlace.length() >= 5 && toPlace.length() < 15) {
				System.out.println("to is valid");
				toValid = true;
			} else {
				System.out.println("to is not valid");
				toValid = false;
			}

			String address = dto.getAddress();
			if (address != null && !address.isEmpty() && address.length() >= 5 && address.length() < 15) {
				System.out.println("Address is valid");
				addressValid = true;
			} else {
				System.out.println("address is not valid");
				addressValid = false;
			}

			String married = dto.getMarried();
			if (married != null && !married.isEmpty() && married.length() >= 5 && married.length() < 15) {
				System.out.println("married is valid");
				marriedValid = true;
			} else {
				System.out.println("married is not valid");
				marriedValid = false;
			}

			String passPort = dto.getPassportNo();
			if (passPort != null && !passPort.isEmpty() && passPort.length() >= 3 && passPort.length() < 12) {
				System.out.println("passport is valid");
				passportValid = true;
			} else {
				System.out.println("passport is not valid");
				passportValid = false;
			}

			String education = dto.getEdu().toString();
			if (education != null && !education.isEmpty() && education.length() >= 5 && education.length() < 15) {
				System.out.println("education is valid");
				educationValid = true;
			} else {
				System.out.println("education is not valid");
				educationValid = false;
			}
			if (nameValid && fromValid && toValid && addressValid && marriedValid && passportValid && educationValid) {
				dao.save(dto);
				System.out.println("data is valid");
				return 1;
			}
			System.out.println("data is invalid");
			return 0;
		}
		System.out.println("dto is null cannot pass to dao");

		return 0;
	}

	@Override
	public void validateAndSaveAll(Collection<CustomerDTO> collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CustomerDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int total() {
		// TODO Auto-generated method stub
		return 0;
	}
}

	


