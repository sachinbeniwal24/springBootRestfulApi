package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.CompanyDto;
import com.example.SpringBootRestfulProgram1.entities.Company;

import java.util.List;

public interface CompanyService {
    Company createCompany(CompanyDto company);

    List<Company> getAllCompany();

    public Company updateCompany(int id ,Company comapny);

    public void deleteCompany(int id );



}
