package com.cognizant.orm_learn.service;

import com.cognizant.orm_learn.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeCriteriaService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> getPermanentEmployees(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        cq.select(root).where(cb.equal(root.get("permanent"), true));
        return entityManager.createQuery(cq).getResultList();
    }
}
