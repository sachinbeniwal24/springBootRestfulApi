package com.example.SpringBootRestfulProgram1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DepartmentDto {

    private int id;

    @NotBlank(message = "Department name is required")
    private String name;

    @Size(min = 3, max = 30, message = "Location must be between 3 and 30 characters")
    private String location;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }


}
