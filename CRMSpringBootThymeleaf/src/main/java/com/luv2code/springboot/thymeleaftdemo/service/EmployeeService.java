package com.luv2code.springboot.thymeleaftdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleaftdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee theEmployee);

	public Employee getEmployee(int theId);

	public void deleteEmployee(int theId);
	
}
