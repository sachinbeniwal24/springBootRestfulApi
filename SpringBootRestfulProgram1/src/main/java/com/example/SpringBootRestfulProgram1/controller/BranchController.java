package com.example.SpringBootRestfulProgram1.controller;

import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.entities.Company;
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
    @PostMapping("/create/{companyId}")
    public ResponseEntity<BranchDto> createBranch(@PathVariable int companyId , @RequestBody BranchDto branchDto) {
        BranchDto createdBranch = branchservice.createBranch(companyId, branchDto);
        return ResponseEntity.ok(createdBranch);
    }
    @GetMapping("/branches")
    public List<Branch>getAllBranch(){
        return branchservice.getAllBranchDetails();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Branch> updateBranch(@Valid @PathVariable int id , @RequestBody Branch branch) {
        Branch updateBranch = branchservice.updateBranch(id, branch);
        if (updateBranch != null) {
            return ResponseEntity.ok(updateBranch);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteBranch(@PathVariable int id){
        branchservice.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }

}
