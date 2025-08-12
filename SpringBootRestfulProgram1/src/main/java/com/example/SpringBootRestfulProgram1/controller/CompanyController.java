package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.CompanyDto;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping("/create")
    public ResponseEntity<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto createdCompany = companyService.createCompany(companyDto);
        return ResponseEntity.ok(createdCompany);
    }
    @GetMapping("/companies")
    public List<Company> getAllCompanyDetails(){
        return companyService.getAllCompanyies();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@Valid @PathVariable int id ,@RequestBody Company company){
        Company  updateCompany=companyService.updateCompany(id,company);
        if(updateCompany!=null){
            return ResponseEntity.ok(updateCompany);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id ){
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }




}
