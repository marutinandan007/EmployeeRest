package com.spring.java.EmployeeRest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.java.EmployeeRest.model.Department;
import com.spring.java.EmployeeRest.repository.DepartmentRepository;

@Service
public class DepartmentService {


    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save( Department department ){
        return departmentRepository.save(department);
    }

   // @CustomAnnotation
    public Department findById(Integer id ){
        return departmentRepository.findById(id).orElse(null);
    }
}
