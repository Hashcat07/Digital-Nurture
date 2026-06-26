package com.cognizant.employee_manangement_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByNameNamed",
                query = "SELECT e FROM Employee e WHERE e.name = :name"
        ),
        @NamedQuery(
                name = "Employee.findAllOrderByEmail",
                query = "SELECT e FROM Employee e ORDER BY e.email ASC"
        )
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
