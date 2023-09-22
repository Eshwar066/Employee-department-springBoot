package com.Microservices.employeeservice.Controller;

import com.Microservices.employeeservice.Model.Employee;
import com.Microservices.employeeservice.Repositary.EmployeeRepositary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER =  LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepositary repositary;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        LOGGER.info("Employee add: {}", employee);
        return repositary.addEmpolyee(employee);
    }

    @GetMapping("/employeeId/{id}")
    public Employee findById(@PathVariable Long id){
        return repositary.findById(id);
    }

    @GetMapping
    public List<Employee> findAll(){
        return repositary.findAll();
    }

    @GetMapping("/departmentId/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id){
        return repositary.findByDepartment(id);
    }


}
