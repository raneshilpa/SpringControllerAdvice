package com.example.springcontrolleradvice.dao;

import com.example.springcontrolleradvice.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmpRepository extends CrudRepository<Employee,Integer>
{
  public Employee findById(int id);



}
