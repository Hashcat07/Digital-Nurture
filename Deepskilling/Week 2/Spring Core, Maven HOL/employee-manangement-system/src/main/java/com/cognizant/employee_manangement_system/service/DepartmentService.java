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
        Department existing=findById(id);
        existing.setName(updated.getName());
        return departmentRepository.save(existing);
    }

    public void delete(Long id){
        departmentRepository.deleteById(id);
    }

    public Department searchByName(String name) {
        return departmentRepository.searchByName(name);
    }

    public List<Department> searchByNameKeyword(String keyword) {
        return departmentRepository.searchByNameKeyword(keyword);
    }

    public List<Department> findDepartmentsWithEmployees() {
        return departmentRepository.findDepartmentsWithEmployees();
    }

    public Department findByNameNamed(String name) {
        return departmentRepository.findByNameNamed(name);
    }

    public List<Department> findAllOrderByName() {
        return departmentRepository.findAllOrderByName();
    }
}
