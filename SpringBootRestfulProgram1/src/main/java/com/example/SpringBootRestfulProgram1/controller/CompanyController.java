package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.CompanyDto;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController{
    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public CustomResponse<Company> createCompany(@RequestBody CompanyDto companyDto) {
        return success(companyService.createCompany(companyDto),"Company create successfully");
    }

    @GetMapping("")
    public CustomResponse<List<Company>> getAllCompanyDetails() {
        return success(companyService.getAllCompany(),"All Company fetched successfully");
    }

    @PutMapping("/{id}")
    public CustomResponse <Company>updateCompany(@Valid @PathVariable int id, @RequestBody Company company) {
        return success(companyService.updateCompany(id,company),"Company updated successfully");

    }

    @DeleteMapping("/{id}")
    public CustomResponse<String> deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
     return  success(null,"Company deleted successfully");
    }
}
