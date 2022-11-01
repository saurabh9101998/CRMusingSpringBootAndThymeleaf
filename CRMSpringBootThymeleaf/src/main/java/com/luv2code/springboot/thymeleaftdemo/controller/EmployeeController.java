package com.luv2code.springboot.thymeleaftdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleaftdemo.entity.Employee;
import com.luv2code.springboot.thymeleaftdemo.service.EmployeeService;



@Controller
@RequestMapping("/employees")
public class EmployeeController {
	private List<Employee> theEmployees;
	@Autowired
	private EmployeeService employeeService;

	@PostConstruct
	private void loadData() {
		theEmployees=employeeService.getEmployees();

	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel) {
		
		Employee employee = new Employee();
		theModel.addAttribute("employee",employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveNewEmployee(@ModelAttribute("employee") Employee employee) {
	
		employeeService.saveEmployee(employee);
		
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model theModel) {
		
		Employee employee = employeeService.getEmployee(id);
		
		theModel.addAttribute("employee",employee);
		
		return "employees/employee-form";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		employeeService.getEmployee(id);
		
		
		
		return "redirect:/employees/list";
	}

}
