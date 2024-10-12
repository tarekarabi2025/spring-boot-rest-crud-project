package com.tarek.springboot.cruddemo.service;


import com.tarek.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    // this method we can use it in save and update employee because we implement it by merge() method
    Employee saveEmployee(Employee theEmployee);

    void deleteById(int theId) ;
}
