package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.entities.Employee;
import com.example.SpringBootRestfulProgram1.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImp implements EmpService {
    @Autowired
    private EmpRepository empRepository;

    @Override
    public Employee createEmployee(Employee employee) {

        return empRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {

        return empRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {

        return empRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(int id, Employee newEmployee) {
       Employee employee = empRepository.findById(id).orElse(null);
        if(employee != null) {
            return empRepository.save(newEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int id) {
        empRepository.deleteById(id);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return empRepository.findByNameContainingIgnoreCase(name);
    }
}
