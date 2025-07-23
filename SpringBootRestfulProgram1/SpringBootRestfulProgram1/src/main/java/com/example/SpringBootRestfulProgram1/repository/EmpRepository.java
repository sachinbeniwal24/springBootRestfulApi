package com.example.SpringBootRestfulProgram1.repository;

import com.example.SpringBootRestfulProgram1.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Employee,Integer>
{
List<Employee> findByNameContainingIgnoreCase(String name);
}
