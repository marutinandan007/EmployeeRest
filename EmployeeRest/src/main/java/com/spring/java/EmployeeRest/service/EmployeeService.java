package com.spring.java.EmployeeRest.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.EmployeeRest.model.Employee;
import com.spring.java.EmployeeRest.model.EmployeeRequest;
import com.spring.java.EmployeeRest.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;

	public Employee saveEmployee(EmployeeRequest empRequest) {
		Employee emp= Employee.builder().name(empRequest.getName())
				.email(empRequest.getEmail()).phone(empRequest.getPhone()).build();
		return empRepository.save(emp);
	}

	public List<EmployeeRequest> getAllEmp() {
		// TODO Auto-generated method stub
		
		List<Employee> listEmp =empRepository.findAll();
		System.out.println(listEmp);
		List<EmployeeRequest> listEmpReq= listEmp.stream().map(e-> EmployeeRequest.builder().id(e.getId()).name(e.getName())
				.email(e.getEmail()).phone(e.getPhone()).build()).collect(Collectors.toList());
		return listEmpReq;
	}

}
