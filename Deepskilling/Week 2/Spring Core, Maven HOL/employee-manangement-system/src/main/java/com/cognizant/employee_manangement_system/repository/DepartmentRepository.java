package com.cognizant.employee_manangement_system.repository;

import com.cognizant.employee_manangement_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);
}