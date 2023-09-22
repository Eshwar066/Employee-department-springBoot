package com.Microservices.employeeservice.Repositary;
import com.Microservices.employeeservice.Model.Employee;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepositary {
    private List<Employee> employees=new ArrayList<>();

    public Employee addEmpolyee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long id){
         return employees.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId){
         return employees.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }

}
