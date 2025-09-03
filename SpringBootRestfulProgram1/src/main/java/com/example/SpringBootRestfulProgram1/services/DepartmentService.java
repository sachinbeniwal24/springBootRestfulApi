package com.example.SpringBootRestfulProgram1.services;


import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    DepartmentDto createdDepartment(DepartmentDto departmentDto);
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(int id);
}
