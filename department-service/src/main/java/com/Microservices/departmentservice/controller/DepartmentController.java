package com.Microservices.departmentservice.controller;

import com.Microservices.departmentservice.client.EmployeeClient;
import com.Microservices.departmentservice.model.Department;

import com.Microservices.departmentservice.repositary.DepartmentRepositary;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
@RequestMapping("/department")
public class DepartmentController  {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentRepositary repositary;

    @Autowired
    private EmployeeClient employeeClient;

    @PostMapping
    public Department add(@RequestBody Department department){
        LOGGER.info("Department add: {}", department);
        return repositary.addDepartment(department);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("Department findAll");
        return repositary.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("Department findById", id);
        return repositary.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("Department findAllWithEmployees");
        List<Department> departments= repositary.findAll();
        departments.forEach(department -> department.setEmployees(employeeClient.findByDepartmentId(department.getId())));
        return departments;
    }


}
