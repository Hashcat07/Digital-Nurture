package com.cognizant.employee_manangement_system.repository;

import com.cognizant.employee_manangement_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

}
