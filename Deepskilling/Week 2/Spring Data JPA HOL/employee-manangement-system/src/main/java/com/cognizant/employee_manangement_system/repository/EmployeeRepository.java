package com.cognizant.employee_manangement_system.repository;

import com.cognizant.employee_manangement_system.entity.Employee;
import com.cognizant.employee_manangement_system.projection.EmployeeDto;
import com.cognizant.employee_manangement_system.projection.EmployeeNameEmail;
import com.cognizant.employee_manangement_system.projection.EmployeeSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);
    Employee findByEmail(String email);
    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> searchByName(@Param("name") String name);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:keyword%")
    List<Employee> searchByEmailKeyword(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    @Query(value = "SELECT * FROM employee WHERE name = :name", nativeQuery = true)
    List<Employee> findByNameNative(@Param("name") String name);

    List<Employee> findByNameNamed(@Param("name") String name);

    List<Employee> findAllOrderByEmail();

    List<EmployeeNameEmail> findNameEmailByDepartmentId(Long id);

    List<EmployeeSummary> findSummaryByDepartmentId(Long departmentId);

    @Query("SELECT new com.cognizant.employee_manangement_system.projection.EmployeeDto(e.name, e.email) " +
            "FROM Employee e WHERE e.department.id = :deptId")
    List<EmployeeDto> fetchEmployeeDtos(@Param("deptId") Long deptId);

}
