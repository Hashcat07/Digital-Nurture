package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeDao.class);
    private final List<Employee> EMPLOYEE_LIST;

    public EmployeeDao(){
        ApplicationContext context=new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST=context.getBean("employeeList",List.class);
    }

    public List<Employee> getAllEmployees(){
        LOGGER.info("START");
        LOGGER.info("END");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee)throws EmployeeNotFoundException{
        LOGGER.info("START");
        for(int i=0;i<EMPLOYEE_LIST.size();i++){
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                LOGGER.info("END");
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found : " + employee.getId());
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        boolean removed = EMPLOYEE_LIST.removeIf(e -> e.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException("Employee not found : " + id);
        }
        LOGGER.info("END");
    }
}
