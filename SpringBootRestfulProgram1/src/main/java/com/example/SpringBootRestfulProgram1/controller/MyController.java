package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.EmployeeDto;
import com.example.SpringBootRestfulProgram1.entities.Employee;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.EmpService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class MyController extends BaseController {
    @Autowired
    private EmpService employeeServices;

    @PostMapping("/create")
    public CustomResponse<Employee> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
        return success(employeeServices.createEmployee(employeeDto), "Employee created successfully");
    }

    @GetMapping("")
    public  CustomResponse<List<Employee>> getAllEmployee() {
        return success(employeeServices.getAllEmployees(), "All Employees fetched successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<Optional<Employee>>getById(@PathVariable int id) {
        return success(employeeServices.getById(id), "Employee fetched by ID successfully");
    }

    @GetMapping("/{name}")
    public CustomResponse<List<Employee>> getByName(@PathVariable String name) {
        return success(employeeServices.getByName(name), "Employees fetched by name successfully") ;

    }

    @PutMapping("/update/{id}")
    public CustomResponse<Employee>UpdateEmployeeDetails(@PathVariable int id, @RequestBody Employee emp) {
        return success(employeeServices.updateEmployeeDetails(id, emp), "Employee updated successfully");
    }

    @DeleteMapping("/delete/{id}")
    public CustomResponse<String> deleteEmployee(@PathVariable int id) {
        employeeServices.deleteEmployee(id);
        return success( null,"Employee deleted successfully");
    }

    @GetMapping("/list/page")
    public CustomResponse<Page<Employee>> getAllByPage(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        return success(employeeServices.getAllByPage(PageRequest.of(page, size)), "Employees fetched by page successfully");
    }
}