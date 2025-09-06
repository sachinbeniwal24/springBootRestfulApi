package com.example.SpringBootRestfulProgram1.services;


import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department createDepartment(DepartmentDto department);
    List<Department> getAllDepartments();
    Optional<Department> getDepartmentById(int id);
}
