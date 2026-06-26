package com.cognizant.employee_manangement_system.service;

import com.cognizant.employee_manangement_system.entity.Department;
import com.cognizant.employee_manangement_system.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department save(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department findById(Long id){
        return departmentRepository.findById(id).orElseThrow(()->new RuntimeException("Department Not Found: "+ id));
    }

    public Department update(long id,Department updated){
        Department existing=departmentRepository.findById(id);
        existing.setName(updated.getName());
        departmentRepository.save(existing);
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }

}
