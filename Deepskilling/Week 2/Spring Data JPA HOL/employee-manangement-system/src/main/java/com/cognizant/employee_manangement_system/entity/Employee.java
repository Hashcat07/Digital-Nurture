package com.cognizant.employee_manangement_system.entity;

import jakarta.persistence.*;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@DynamicInsert
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
public class Employee extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @NaturalId
    @Column(unique = true)
    private String email;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime hbCreatedAt;

    @UpdateTimestamp
    private LocalDateTime hbUpdatedAt;

    @Formula("upper(name)")
    private String nameUpper;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;
}
