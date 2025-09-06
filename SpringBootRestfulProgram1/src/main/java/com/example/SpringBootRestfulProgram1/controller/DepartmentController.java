package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import static com.example.SpringBootRestfulProgram1.response.CustomResponse.success;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/create")
    public CustomResponse<Department> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        Department createDepartment = departmentService.createDepartment(departmentDto);
        return success(createDepartment, "Department created successfully");
    }

    @GetMapping("")
    public CustomResponse<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return success(departments, "All Departments fetched successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<Optional<Department>> getDepartmentById(@PathVariable int id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return success(department, "Department fetched by ID successfully");
    }
}
