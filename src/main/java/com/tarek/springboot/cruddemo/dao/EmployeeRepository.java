package com.tarek.springboot.cruddemo.dao;

import com.tarek.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // that is it ... no need to write any code
}
