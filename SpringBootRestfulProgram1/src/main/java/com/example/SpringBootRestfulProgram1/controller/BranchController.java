package com.example.SpringBootRestfulProgram1.controller;
import com.example.SpringBootRestfulProgram1.dto.BranchDto;
import com.example.SpringBootRestfulProgram1.entities.Branch;
import com.example.SpringBootRestfulProgram1.response.CustomResponse;
import com.example.SpringBootRestfulProgram1.services.BranchService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
    @RequestMapping("/branch")
    public class BranchController extends BaseController {
        @Autowired
        private BranchService branchService;

        @PostMapping("/create")
        public CustomResponse<Branch> createBranch(@PathVariable int companyId, @RequestBody BranchDto branchDto) {
            return success(branchService.createBranch(companyId,branchDto),"branch created successfully");
        }

        @GetMapping("/branches")
        public CustomResponse<List<Branch>> getAllBranch() {
            return success(branchService.getAllBranchDetails(),"All branch fetched successfully");
        }

        @PutMapping("/{id}")
        public CustomResponse<Branch> updateBranch(@Valid @PathVariable int id, @RequestBody Branch branch) {
            return success(branchService.updateBranch(id, branch), "Branch updated successfully");
        }

        @DeleteMapping("/{id}")
        public CustomResponse<String> deleteBranch(@PathVariable int id) {
            branchService.deleteBranch(id);
            return success(null,"branch deleted successfully");
        }
    }


