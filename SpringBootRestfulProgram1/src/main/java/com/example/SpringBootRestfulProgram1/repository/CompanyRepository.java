package com.example.SpringBootRestfulProgram1.repository;

import com.example.SpringBootRestfulProgram1.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface  CompanyRepository extends JpaRepository<Company, Integer>{
    Optional<Company> findByName (String name);


}
