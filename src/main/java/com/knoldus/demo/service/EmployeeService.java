package com.knoldus.demo.service;

import com.knoldus.demo.model.Employee;
import com.knoldus.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    
    @Autowired
    EmployeeRepository employeeRepository;
    
    public Employee create(Employee employee){
        return employeeRepository.save(employee);
    }
    public Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
    }
    public Employee update(Long id, Employee employee){
        Employee updateEmployee = employeeRepository.findById(id).get();
        updateEmployee.setName(employee.getName());
        updateEmployee.setEmail(employee.getEmail());
        updateEmployee.setDepartment(employee.getDepartment());
        return employeeRepository.save(updateEmployee);
    }
    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> getfetchAll() {
        return (List<Employee>) employeeRepository.findAll();
    }
}
