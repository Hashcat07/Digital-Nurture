package com.cognizant.employee_manangement_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;

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
public class Department extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @BatchSize(size = 10)
    @JsonIgnore
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;




}
