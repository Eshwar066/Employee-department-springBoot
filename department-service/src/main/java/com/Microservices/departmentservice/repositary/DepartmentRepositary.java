package com.Microservices.departmentservice.repositary;

import com.Microservices.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositary {
    List<Department> departments=new ArrayList<>();

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department findById(Long id){
        return departments.stream().filter(department->department.getId()==id).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }
}
