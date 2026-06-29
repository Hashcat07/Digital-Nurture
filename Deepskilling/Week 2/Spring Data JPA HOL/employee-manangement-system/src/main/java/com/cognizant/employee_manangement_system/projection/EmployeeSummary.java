package com.cognizant.employee_manangement_system.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeSummary {

    String getName();
    String getEmail();

    @Value("#{target.name + ' <' + target.email + '>'}")
    String getDisplayLabel();

    @Value("#{target.department != null ? target.department.name : 'Unassigned'}")
    String getDepartmentName();
}