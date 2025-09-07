package com.example.SpringBootRestfulProgram1.services;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;

import java.util.List;

public interface BranchService {
    Branch createBranch(int companyId, BranchDto branch);
    List<Branch>getAllBranchDetails();
    public Branch updateBranch(int id , Branch branch);
    public void deleteBranch(int id);




}
