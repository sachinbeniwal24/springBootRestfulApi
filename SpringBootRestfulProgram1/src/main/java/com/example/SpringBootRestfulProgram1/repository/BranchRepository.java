package com.example.SpringBootRestfulProgram1.repository;

import com.example.SpringBootRestfulProgram1.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, Integer>{
    List<Branch> findByCity(String City);
    List<Branch>findByCompanyId(int companyId);

}
