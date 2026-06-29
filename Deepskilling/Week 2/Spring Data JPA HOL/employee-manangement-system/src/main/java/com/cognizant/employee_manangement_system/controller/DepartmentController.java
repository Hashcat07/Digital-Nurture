package com.cognizant.employee_manangement_system.controller;

import com.cognizant.employee_manangement_system.entity.Department;
import com.cognizant.employee_manangement_system.entity.Employee;
import com.cognizant.employee_manangement_system.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public Department create(@RequestBody Department department){
        return departmentService.save(department);
    }

    @GetMapping
    public List<Department> getAll(){
        return departmentService.findAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        return departmentService.findById(id);
    }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id,@RequestBody Department department){
        return departmentService.update(id,department);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        departmentService.delete(id);
        return "Department "+ id+ " Deleted.";
    }

    @GetMapping("/search")
    public Department searchByName(@RequestParam String name) {
        return departmentService.searchByName(name);
    }

    @GetMapping("/search-keyword")
    public List<Department> searchByKeyword(@RequestParam String keyword) {
        return departmentService.searchByNameKeyword(keyword);
    }

    @GetMapping("/with-employees")
    public List<Department> withEmployees() {
        return departmentService.findDepartmentsWithEmployees();
    }

    @GetMapping("/named")
    public Department findByNameNamed(@RequestParam String name) {
        return departmentService.findByNameNamed(name);
    }

    @GetMapping("/sorted-by-name")
    public List<Department> sortedByName() {
        return departmentService.findAllOrderByName();
    }
}
