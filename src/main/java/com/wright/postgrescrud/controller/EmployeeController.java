package com.wright.postgrescrud.controller;

import com.wright.postgrescrud.model.Employee;
import com.wright.postgrescrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee){
        Employee emp = Employee.builder()
            .name(employee.getName())
            .email(employee.getEmail())
            .jobtitle(employee.getJobtitle())
            .build();

        return employeeService.createEmployee(emp);
    }

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee emp = Employee.builder()
            .id(id)
            .name(employee.getName())
            .email(employee.getEmail())
            .jobtitle(employee.getJobtitle())
            .build();

        return employeeService.updateEmployee(emp);
    }
}
