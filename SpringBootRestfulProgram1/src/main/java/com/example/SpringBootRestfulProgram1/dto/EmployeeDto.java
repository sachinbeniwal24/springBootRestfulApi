package com.example.SpringBootRestfulProgram1.dto;

import com.example.SpringBootRestfulProgram1.entities.Department;
import jakarta.validation.constraints.*;

public class EmployeeDto {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String gender;
    @Size(min = 2, max = 30, message = "Department must be between 2 and 30 characters")
    private Department department;
    @NotNull(message = "City cannot be  null")
    private String city;
    @NotNull(message = "Department ID cannot be null")
    private int departmentId;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(@Size Department department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
}
