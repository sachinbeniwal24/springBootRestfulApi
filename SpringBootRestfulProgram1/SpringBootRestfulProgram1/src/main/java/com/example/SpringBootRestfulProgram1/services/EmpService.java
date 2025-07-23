package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmpService {
   public Employee createEmployee(Employee employee);
   public List<Employee> getAllEmployee();
   public Optional<Employee> getEmployeeById(int id);
   public Employee updateEmployee(int id, Employee employee);
   public void deleteEmployee(int id);
   public List<Employee> getEmployeesByName(String name);
}
