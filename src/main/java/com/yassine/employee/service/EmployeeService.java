package com.yassine.employee.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.yassine.employee.entity.Employee;
import com.yassine.employee.entity.Grade;

public interface EmployeeService {
	Employee saveEmployee(Employee e);
	Employee updateEmployee(Employee e);
	void deleteEmployee(Employee e);
	void deleteEmployeeById(int id);
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	
	List<Employee> chercherparnomEmployee(String nom);
	
	List<Employee> chercherparnomEmployeeContains(String nom);
	
	
	List<Employee> findBynometsalaire (String nom,int salaire ); 

	
	List<Employee> findByGrade (Grade grade);
	
	List<Employee> findByGradeIdGraEmp(int id); 
	
	List<Employee> findByOrderByNomEmployeAsc(); 
	/*List<Employee> findByOrderByNomEmployeDesc(); */
	 
	List<Employee> trierEmployeesNomsSalaire ();
	
	
}
