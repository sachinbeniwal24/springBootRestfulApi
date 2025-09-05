package com.example.SpringBootRestfulProgram1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int id ;
    @NotBlank(message = "City cannot be blank")
    private  String city;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="Company_id")
    @JsonIgnore
    private  Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
