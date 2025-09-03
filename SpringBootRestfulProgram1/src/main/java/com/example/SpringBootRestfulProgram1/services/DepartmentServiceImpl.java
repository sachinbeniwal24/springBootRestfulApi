package com.example.SpringBootRestfulProgram1.services;


import com.example.SpringBootRestfulProgram1.dto.DepartmentDto;
import com.example.SpringBootRestfulProgram1.entities.Department;
import com.example.SpringBootRestfulProgram1.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createdDepartment(DepartmentDto departmentDto) {
       return createdDepartment(departmentDto);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }
}
