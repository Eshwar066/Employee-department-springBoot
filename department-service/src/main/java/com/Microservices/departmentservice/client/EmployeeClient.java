package com.Microservices.departmentservice.client;

import com.Microservices.departmentservice.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient  {
    @GetExchange("/employee/departmentId/{id}")
    public List<Employee> findByDepartmentId(@PathVariable Long id);
}
