package com.Microservices.employeeservice.Model;
//by default it is final,it is constructed using constructor,no setters but they have getters
public record Employee(Long id, Long departmentId, String name, int age, String position) {

}
