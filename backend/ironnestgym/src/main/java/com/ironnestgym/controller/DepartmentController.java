package com.ironnestgym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ironnestgym.entity.Department;
import com.ironnestgym.service.DepartmentService;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    //Save operation
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {        
        return departmentService.saveDepartment(department);
    }
    
     // Read operation
     @GetMapping("/departments")
     public List<Department> fetchDepartmentList()
     {
         return departmentService.fetchDepartmentList();
     }

      // Update operation
    @PutMapping("/departments/{id}")
    public Department
    updateDepartment(@RequestBody Department department, @PathVariable("id") Long departmentId){
        return departmentService.updateDepartment(department, departmentId);
    }

     // Delete operation
     @DeleteMapping("/departments/{id}")
     public String deleteDepartmentById(@PathVariable("id")Long departmentId){
         departmentService.deleteDepartmentById(departmentId);
         return "Deleted Successfully";
     }
}
