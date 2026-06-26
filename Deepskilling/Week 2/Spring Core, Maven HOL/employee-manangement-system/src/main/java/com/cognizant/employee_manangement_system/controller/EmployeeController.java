package com.cognizant.employee_manangement_system.controller;

import com.cognizant.employee_manangement_system.entity.Employee;
import com.cognizant.employee_manangement_system.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public Employee create(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAll(){
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.update(id,employee);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return "Employee " +id+ " Deleted.";
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/paged")
    public Page<Employee> getPaged(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy, @RequestParam(defaultValue = "asc") String direction){
        return employeeService.findALlPaged(page, size, sortBy, direction);
    }
}
