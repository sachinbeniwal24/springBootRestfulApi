package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.CompanyDto;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompanyServiceImp implements CompanyService{
  @Autowired
  private CompanyRepository companyRepository;

    @Override
    public CompanyDto createCompany(CompanyDto companyDto) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setEmail(companyDto.getEmail());

        Company savedCompany = companyRepository.save(company);
        CompanyDto savedCompanyDto = new CompanyDto();
        savedCompanyDto.setId(savedCompany.getId());
        savedCompanyDto.setName(savedCompany.getName());
        savedCompanyDto.setEmail(savedCompany.getEmail());

        return savedCompanyDto;
    }

    @Override
    public List<Company> getAllCompanyies() {
        return companyRepository.findAll();
    }

    @Override
    public Company updateCompany(int id, Company newComapny) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            return companyRepository.save(newComapny);
        }
          return null;
    }

    @Override
    public void deleteCompany(int id) {
        companyRepository.deleteById(id);

    }
}
