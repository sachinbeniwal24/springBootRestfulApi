package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController extends BaseController {
@Autowired
    private  DepartmentService departmentService;


    @PostMapping("/create")
    public CustomResponse<Department> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        return success( departmentService.createDepartment(departmentDto),"Department created successfully");
    }

    @GetMapping("")
    public CustomResponse<List<Department>> getAllDepartments() {
        return success( departmentService.getAllDepartments(),"All Departments fetched successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<Optional<Department>> getDepartmentById(@PathVariable int id) {
        return success( departmentService.getDepartmentById(id),"Department fetched by ID successfully");
    }
}
