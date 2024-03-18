package com.wright.postgrescrud.service;

import com.wright.postgrescrud.model.Employee;
import com.wright.postgrescrud.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee created successfully";
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public String updateEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getId()).orElse(null);
        assert emp != null;
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setJobtitle(employee.getJobtitle());
        employeeRepository.save(emp);
        return "Employee updated successfully";
    }
}
