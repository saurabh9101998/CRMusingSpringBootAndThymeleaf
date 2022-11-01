package com.luv2code.springboot.thymeleaftdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.thymeleaftdemo.dao.EmployeeRespositoy;
import com.luv2code.springboot.thymeleaftdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	// need to inject customer dao
	@Autowired
	private EmployeeRespositoy employeeRespositoy;

	@Override
	@Transactional
	public List<Employee> getEmployees() {
		return employeeRespositoy.findAllByOrderByLastNameAsc();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		employeeRespositoy.save(theEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int theId) {

		Employee theEmployee = null;

		Optional<Employee> result = employeeRespositoy.findById(theId);

		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee with id = " + theId);
		}
		return theEmployee;
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {

		employeeRespositoy.deleteById(theId);
	}
}
