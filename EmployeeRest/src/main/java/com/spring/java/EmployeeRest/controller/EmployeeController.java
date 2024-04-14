package com.spring.java.EmployeeRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.java.EmployeeRest.model.Employee;
import com.spring.java.EmployeeRest.model.EmployeeRequest;
import com.spring.java.EmployeeRest.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping(value="/")
	public Employee saveEmployee(@RequestBody EmployeeRequest emp) {
		return empService.saveEmployee(emp);
	}
	
	@GetMapping(value="/emplist")
	public List<EmployeeRequest> getAllEmployee(){
		return empService.getAllEmp();
	}

}
