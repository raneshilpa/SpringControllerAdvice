package com.example.springcontrolleradvice.controller;

import com.example.springcontrolleradvice.Service.EmployeeService;
import com.example.springcontrolleradvice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

@Autowired
EmployeeService eService;

@GetMapping("/employees")
public List<Employee> getList ()
{
        return eService.getList();
}


@GetMapping("/employees/{id}")
public Employee get (@PathVariable Integer id) {
    return eService.getEmployee(id);
}




}
