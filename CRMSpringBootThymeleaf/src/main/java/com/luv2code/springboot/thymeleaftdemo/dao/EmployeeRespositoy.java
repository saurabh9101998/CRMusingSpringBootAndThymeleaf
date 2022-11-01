package com.luv2code.springboot.thymeleaftdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.springboot.thymeleaftdemo.entity.Employee;

public interface EmployeeRespositoy extends JpaRepository<Employee, Integer> {
	
	public  List<Employee> findAllByOrderByLastNameAsc();

}
