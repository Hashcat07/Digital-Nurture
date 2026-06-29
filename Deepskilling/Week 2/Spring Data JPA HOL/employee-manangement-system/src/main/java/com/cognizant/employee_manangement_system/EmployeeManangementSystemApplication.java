package com.cognizant.employee_manangement_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManangementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManangementSystemApplication.class, args);
	}

}
