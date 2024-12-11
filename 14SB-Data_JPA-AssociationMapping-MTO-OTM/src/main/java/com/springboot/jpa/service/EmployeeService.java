package com.springboot.jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Address;
import com.springboot.jpa.entity.Employee;
import com.springboot.jpa.repository.AddressRepository;
import com.springboot.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private AddressRepository addrRepo;

//===========inserting Employee with Addresses=======================	
	public void saveEmpWithAddr() {

		Employee e = new Employee();
		e.setName("Max");
		e.setSalary(1200.0);

		Address a1 = new Address();
		a1.setCity("Kolkata");
		a1.setState("WB");
		a1.setType("Present");

		Address a2 = new Address();
		a2.setCity("Varanasi");
		a2.setState("UP");
		a2.setType("Permanent");

		List<Address> addrList = Arrays.asList(a1, a2);

		// setting addresses to employee
		e.setAddr(addrList);

		// setting employee to addresses
		a1.setEmp(e);
		a2.setEmp(e);
		empRepo.save(e);
	}

//==================Getting employee records============================	

	// We'll get Employee record along with Address records because of
	// "FetchType.EAGER"

	public void getEmp() {
		Optional<Employee> byId = empRepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}

//========================Deleting Employee================================

	/*
	 * It will delete Employee along with associated Address records because of
	 * "CascadeType.ALL" It will delete Address(child) first then delete the
	 * Employee(parent) (we should write "CascadeType" in parent)
	 */
	public void deleteEmp() {
		empRepo.deleteById(1);
	}

//========================Getting Address=====================================	

	/*
	 * We'll get Address along with Employee record because Address is having
	 * "emp_id" as foreign key
	 */

	public void getAddr() {
		Optional<Address> byId = addrRepo.findById(1);
		if (byId.isPresent()) {
			System.out.println(byId.get());
		}
	}
}
