package com.cognizant.employee_manangement_system.service;

import com.cognizant.employee_manangement_system.entity.Employee;
import com.cognizant.employee_manangement_system.projection.EmployeeDto;
import com.cognizant.employee_manangement_system.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    @PersistenceContext
    private EntityManager entityManager;

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

    public List<Employee> findByName(String name) {
        return employeeRepository.searchByName(name);
    }

    public Page<Employee> findAllPaged(int page, int size, String sortBy, String direction){

        Sort.Direction dir = direction.equalsIgnoreCase("desc")
                ? Sort.Direction.DESC
                : Sort.Direction.ASC;

        Pageable pageable = PageRequest.of(page, size, Sort.by(dir, sortBy));

        return employeeRepository.findAll(pageable);
    }

    public List<EmployeeDto> getDtosByDepartment(Long deptId) {
        return employeeRepository.fetchEmployeeDtos(deptId);
    }

    @Transactional
    public List<Employee> bulkCreate(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Transactional
    public void batchInsert(List<Employee> employees) {
        int batchSize = 20;
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }


}
