package com.knoldus.demo.controller;

import com.knoldus.demo.model.Employee;
import com.knoldus.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService service;
    
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") Long employeeId){
        return service.getEmployee(employeeId);
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return service.create(employee);
    }
    
    @PutMapping("/{employeeId}")
    public Employee update(@PathVariable("employeeId") Long employeeId,
            @RequestBody Employee employee){
        return service.update(employeeId,employee);
    }
    
    @DeleteMapping("/{employeeId}")
    public Map<String, Boolean> delete(@PathVariable("employeeId") Long employeeId){
        service.delete(employeeId);
        Map<String, Boolean> map = new HashMap<>();
        map.put("deleted",true);
        return map;
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getfetchAll();
    }
}
