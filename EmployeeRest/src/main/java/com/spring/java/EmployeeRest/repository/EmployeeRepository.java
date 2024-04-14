package com.spring.java.EmployeeRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.java.EmployeeRest.model.Employee;

import jakarta.persistence.Id;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Id>{

}
