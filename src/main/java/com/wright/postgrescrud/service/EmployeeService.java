package com.wright.postgrescrud.service;

import com.wright.postgrescrud.model.Employee;
import com.wright.postgrescrud.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee created successfully";
    }
}
