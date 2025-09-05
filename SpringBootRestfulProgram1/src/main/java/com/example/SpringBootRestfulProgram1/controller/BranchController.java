package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.entities.Company;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.Branchservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/branch")
    public class BranchController {
        @Autowired
        private Branchservice branchservice;

        @PostMapping("/create")
        public CustomResponse<BranchDto> createBranch(@PathVariable int companyId, @RequestBody BranchDto branchDto) {
            BranchDto createdBranch = branchservice.createBranch(companyId, branchDto);
            return new CustomResponse<>(true, "Branch created successfully", createdBranch);
        }

        @GetMapping("/branches")
        public List<Branch> getAllBranch() {
            return branchservice.getAllBranchDetails();
        }

        @PutMapping("/{id}")
        public CustomResponse<Branch> updateBranch(@Valid @PathVariable int id, @RequestBody Branch branch) {
            Branch updateBranch = branchservice.updateBranch(id, branch);
           return new CustomResponse<>(true, "Branch updated successfully", updateBranch);
        }

        @DeleteMapping("/{id}")
        public CustomResponse<String> deleteBranch(@PathVariable int id) {
            branchservice.deleteBranch(id);
            return new CustomResponse<>(true, "Branch deleted successfully", null);
        }
    }


