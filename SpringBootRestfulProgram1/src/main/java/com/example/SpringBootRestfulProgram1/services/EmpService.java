package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.EmployeeDto;
import com.example.SpringBootRestfulProgram1.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EmpService {
    Employee createEmployee(EmployeeDto employee);
    List<Employee> getAllEmployees();
    List<Employee> getByName(String name);
    Optional<Employee> getById(int id);
    Employee updateEmployeeDetails(int id, Employee employee);
    void deleteEmployee(int id);
    Page<Employee> getAllByPage(Pageable pageable);
}
