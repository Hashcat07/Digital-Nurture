package com.cognizant.employee_manangement_system.repository;

import com.cognizant.employee_manangement_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    @Query("SELECT d FROM Department d WHERE d.name = :name")
    Department searchByName(@Param("name") String name);

    @Query("SELECT d FROM Department d WHERE d.name LIKE %:keyword%")
    List<Department> searchByNameKeyword(@Param("keyword") String keyword);

    @Query("SELECT DISTINCT d FROM Department d JOIN d.employees e")
    List<Department> findDepartmentsWithEmployees();

    @Query(value = "SELECT * FROM department WHERE name = :name", nativeQuery = true)
    Department findByNameNative(@Param("name") String name);

    Department findByNameNamed(@Param("name") String name);

    List<Department> findAllOrderByName();
}