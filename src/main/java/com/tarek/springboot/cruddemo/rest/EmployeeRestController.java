package com.tarek.springboot.cruddemo.rest;

import com.tarek.springboot.cruddemo.entity.Employee;
import com.tarek.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
      return   employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
       Employee theEmployee =  employeeService.findById(employeeId);
       if ( theEmployee == null){
           throw new RuntimeException("the employee not found "+employeeId);
       }
       return theEmployee;
    }

    // add a new employee to the data base

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        // also just in case they pass an id in json ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);
        return dbEmployee;
    }

    // update an existing employee using PUT / employees - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee ){
        Employee dbEmployee = employeeService.saveEmployee(theEmployee);
        return dbEmployee;
    }

    // delete an employee by the id

    @DeleteMapping("/employees/{employeeId}")
    public String delteEmplyee(@PathVariable int employeeId){
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee==null){
            throw new RuntimeException("Enployee is not found - "+ employeeId);
        }
        employeeService.deleteById(employeeId);
        return "Deleted employee id : "+ employeeId;
    }


}
