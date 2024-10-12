package com.tarek.springboot.cruddemo.service;

import com.tarek.springboot.cruddemo.dao.EmployeeRepository;
import com.tarek.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        //Employee one = employeeRepository.getReferenceById(theId);
        Optional<Employee> result = employeeRepository.findById(theId);
        Employee theEmployee = null;
        if (result.isPresent()){
            theEmployee= result.get();
        }else {
            // we didn't find the employee
            throw new RuntimeException("the employee is not found -"+theId);
        }

        return theEmployee;
    }


    @Override
    public Employee saveEmployee(Employee theEmployee) {
        return   employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
