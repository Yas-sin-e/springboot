package com.yassine.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.yassine.employee.entity.Employee;
import com.yassine.employee.entity.Grade;
import com.yassine.employee.entity.Grade;

@SpringBootApplication
public class EmployeeApplication implements CommandLineRunner {
	@Autowired 
	private RepositoryRestConfiguration repositoryRestConfiguration; 

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Employee.class,Grade.class);
		
	}

}
