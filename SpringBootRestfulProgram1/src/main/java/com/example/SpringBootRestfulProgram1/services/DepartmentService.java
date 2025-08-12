package com.example.SpringBootRestfulProgram1.services;


import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createdDepartment(DepartmentDto departmentDto);
    List<DepartmentDto> getAllDepartments();
    DepartmentDto getDepartmentById(int id);
}
