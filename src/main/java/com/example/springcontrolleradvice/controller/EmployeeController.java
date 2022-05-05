package com.example.springcontrolleradvice.controller;

import com.example.springcontrolleradvice.Service.EmployeeService;
import com.example.springcontrolleradvice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

    @GetMapping("/employees")
    public List<Employee> getList() {
        return eService.getList();
    }


    @GetMapping("/employees/{id}")
    public Employee get(@PathVariable Integer id) {
        return eService.getEmployee(id);
    }

    @PostMapping("/employees/addemployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee em = null;
        try {
            em = this.eService.addEmployee(employee);
            System.out.println(employee);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/employees/deleteemployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)
    {
        try
        {
            this.eService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e)
        {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Integer id)
    {
        try
        {
            this.eService.updateEmployee(employee,id);
            return ResponseEntity.ok().body(employee);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();


    }


}