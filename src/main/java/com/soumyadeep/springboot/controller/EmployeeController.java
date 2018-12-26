package com.soumyadeep.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.soumyadeep.springboot.model.Employee;
import com.soumyadeep.springboot.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/addNewEmployee", method=RequestMethod.POST)
	public String newEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		return ("redirect:/listEmployees");
	}
	
	@RequestMapping(value="/addNewEmployee", method=RequestMethod.GET)
	public ModelAndView addNewEmployee() {
		
		return new ModelAndView("newEmployee", "form", new Employee());
	}

	@RequestMapping(value="/listEmployees", method=RequestMethod.GET)
	public ModelAndView listEmployee(){
		
		List<Employee> list = employeeRepository.findAll();
		
		return new ModelAndView("allEmployees", "employees", list);
	}
}
