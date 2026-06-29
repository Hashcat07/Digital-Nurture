package com.cognizant.employee_manangement_system.projection;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor     
public class EmployeeDto {
    private String name;
    private String email;
}