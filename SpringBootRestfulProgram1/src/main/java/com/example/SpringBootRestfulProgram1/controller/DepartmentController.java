package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static jdk.vm.ci.hotspot.HotSpotCompilationRequestResult.success;


@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/create")
    public CustomResponse<DepartmentDto> createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
        DepartmentDto createdDepartment = departmentService.createdDepartment(departmentDto);
        return success(createdDepartment, "Department created successfully");
    }

    @GetMapping("")
    public CustomResponse<List<DepartmentDto>> getAllDepartments() {
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return success(departments, "All Departments fetched successfully");
    }

    @GetMapping("/{id}")
    public CustomResponse<DepartmentDto> getDepartmentById(@PathVariable int id) {
        DepartmentDto department = departmentService.getDepartmentById(id);
        return success(department, "Department fetched by ID successfully");
    }
}
