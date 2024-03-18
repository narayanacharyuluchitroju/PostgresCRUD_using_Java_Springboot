package com.wright.postgrescrud.controller;

import com.wright.postgrescrud.model.Employee;
import com.wright.postgrescrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
