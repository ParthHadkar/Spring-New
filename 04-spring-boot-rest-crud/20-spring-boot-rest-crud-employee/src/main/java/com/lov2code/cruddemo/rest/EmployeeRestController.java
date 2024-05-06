package com.lov2code.cruddemo.rest;

import com.lov2code.cruddemo.dao.EmployeeDAO;
import com.lov2code.cruddemo.entity.Employee;
import com.lov2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        // if user pass id it will force insert by setting id to 0 instead of update
        employee.setId(0);
        Employee employeeDb = employeeService.save(employee);
        return  employeeDb;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employeeDb = employeeService.save(employee);
        return  employeeDb;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        employeeService.deleteById(employeeId);
        return  "Deleted employee id - "+employeeId;
    }
}
