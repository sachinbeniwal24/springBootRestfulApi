package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.entities.Company;

import java.util.List;

public interface Branchservice  {
    BranchDto createBranch(int companyId, BranchDto branchDto);
    List<Branch>getAllBranchDetails();
    public Branch updateBranch(int id , Branch branch);
    public void deleteBranch(int id);




}
