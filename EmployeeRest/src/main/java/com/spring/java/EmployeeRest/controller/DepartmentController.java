package com.spring.java.EmployeeRest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.java.EmployeeRest.model.Department;
import com.spring.java.EmployeeRest.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public Department save( @RequestBody Department department ){
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Department findById( @PathVariable(value = "id") Integer id ){
        return departmentService.findById(id);
    }
}
