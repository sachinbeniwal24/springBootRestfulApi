package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.entities.Employee;
import com.example.SpringBootRestfulProgram1.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    @Autowired
    private EmpService empService;
//    @PostMapping("/employee")
//    public Employee addEmployeeDetails(@RequestBody Employee employee){
//
//        return empService.createEmployee(employee);
//    }
//
//    @GetMapping("/employee")
//    public List<Employee> getAllEmployeeDetails() {
//        return empService.getAllEmployee();
//    }
//
//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
//        Employee employee= empService.getEmployeeById(id).orElse(null);
//        if(employee!= null) {
//            return ResponseEntity.ok(employee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PutMapping("/employee/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        Employee updatedEmployee = empService.updateEmployee(id, employee);
//        if (updatedEmployee != null) {
//            return ResponseEntity.ok(updatedEmployee);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @DeleteMapping("/employee/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
//        empService.deleteEmployee(id);
//        return ResponseEntity.noContent().build();
//    }
    @GetMapping(value ="/employee", params = "name")
    public List<Employee> getEmployeesByName(@RequestParam String name) {

        return empService.getEmployeesByName(name);
    }



}
