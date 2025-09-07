package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.repository.BranchRepository;
import com.example.SpringBootRestfulProgram1.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImp implements BranchService{
    @Autowired
    private BranchRepository branchRepostiory;
    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public Branch createBranch(int companyId, BranchDto branch) {
        return save(branch);
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
    public Branch save(BranchDto branchDto){
        Branch branch=new Branch();
        branch.setCity(branch.getCity());
        return branchRepostiory.save(branch);
    }
}
