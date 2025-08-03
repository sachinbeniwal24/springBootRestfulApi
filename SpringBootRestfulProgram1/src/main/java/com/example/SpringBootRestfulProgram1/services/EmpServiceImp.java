package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.EmployeeDto;
import com.example.SpringBootRestfulProgram1.entities.Employee;
import com.example.SpringBootRestfulProgram1.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpRepository employeeRepository;

    public Employee createEmployee(EmployeeDto employee) {
        return save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Optional<Employee> getById(int id) {
        return employeeRepository.findById(id);
    }


    @Override
    public Employee updateEmployeeDetails(int id, Employee emp) {
        return employeeRepository.save(emp);

    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> getAllByPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setGender(employeeDto.getGender());
        employee.setDepartment(employeeDto.getDepartment());
        employee.setCity(employeeDto.getCity());
        return employeeRepository.save(employee);
    }





}
