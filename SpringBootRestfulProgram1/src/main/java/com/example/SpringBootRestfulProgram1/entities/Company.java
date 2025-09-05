package com.example.SpringBootRestfulProgram1.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
@Entity
@Table
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
     @NotBlank(message = "Company name cannot be blank")
    private String name;
     @Email(message = "Email should be valid")
    private  String email;
    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Branch> branch;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }
}
