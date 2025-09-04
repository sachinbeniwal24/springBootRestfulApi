package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.repository.BranchRepository;
import com.example.SpringBootRestfulProgram1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImp implements Branchservice{
    @Autowired
    private BranchRepository branchRepostiory;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public BranchDto createBranch(int companyId, BranchDto branchDto)
    {
        Optional<Company> optionalCompany= companyRepository.findById(companyId);
        if(optionalCompany.isEmpty()){
            throw new RuntimeException("Company not found with id: " + companyId);
        }
        Company company = optionalCompany.get();
        Branch branch= new Branch();
        branch.setCity(branchDto.getCity());
        branch.setCompany(company);

        Branch savedBranch = branchRepostiory.save(branch);
        BranchDto savedBranchDto = new BranchDto();
        savedBranchDto.setId(savedBranch.getId());
        savedBranchDto.setCity(savedBranch.getCity());
        return savedBranchDto;


    }

    @Override
    public List<Branch> getAllBranchDetails() {
        return branchRepostiory.findAll();
    }

    @Override
    public Branch updateBranch(int id, Branch newBranch) {
        Branch branch1=branchRepostiory.findById(id).orElse(null);
        if(branch1!=null){
            return branchRepostiory.save(newBranch);
        }
        return null;
    }

    @Override
    public void deleteBranch(int id) {
        branchRepostiory.deleteById(id);
    }
}
