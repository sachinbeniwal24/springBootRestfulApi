package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.CompanyDto;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
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
    public CustomResponse<CompanyDto> createCompany(@RequestBody CompanyDto companyDto) {
        CompanyDto createdCompany = companyService.createCompany(companyDto);
        return new CustomResponse<>(true,  "Company created successfully", createdCompany);
    }

    @GetMapping("/companies")
    public List<Company> getAllCompanyDetails() {
        return companyService.getAllCompanyies();
    }

    @PutMapping("/{id}")
    public CustomResponse <Company>updateCompany(@Valid @PathVariable int id, @RequestBody Company company) {
        Company updateCompany = companyService.updateCompany(id, company);
        return new CustomResponse<>(true, "Company updated successfully", updateCompany);


    }

    @DeleteMapping("/{id}")
    public CustomResponse<String> deleteCompany(@PathVariable int id) {companyService.deleteCompany(id);
        return new CustomResponse<>(true, "Company deleted successfully", null);
    }
}
