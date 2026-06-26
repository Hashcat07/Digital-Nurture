package com.cognizant.employee_manangement_system.service;

import com.cognizant.employee_manangement_system.entity.Employee;
import com.cognizant.employee_manangement_system.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found: "+id));
    }

    public Employee update(Long id,Employee updated){
        Employee existing = findById(id);
        existing.setName(updated.getName());
        existing.setEmail(updated.getEmail());
        existing.setDepartment(updated.getDepartment());
        return employeeRepository.save(existing);
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
