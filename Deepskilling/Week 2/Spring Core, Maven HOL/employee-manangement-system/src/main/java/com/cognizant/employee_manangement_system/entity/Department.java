package com.cognizant.employee_manangement_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(
                name = "Department.findByNameNamed",
                query = "SELECT d FROM Department d WHERE d.name = :name"
        ),
        @NamedQuery(
                name = "Department.findAllOrderByName",
                query = "SELECT d FROM Department d ORDER BY d.name ASC"
        )
})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;




}
