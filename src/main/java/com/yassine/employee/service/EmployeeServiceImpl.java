package com.yassine.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.employee.Repository.EmployeeRepository;
import com.yassine.employee.entity.Employee;
import com.yassine.employee.entity.Grade;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private  EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee e) {
		
		return employeeRepository.save(e);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return employeeRepository.save(e);
	}

	@Override
	public void deleteEmployee(Employee e) {
		employeeRepository.delete(e);
		
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee getEmployee(int id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}
	@Override
	public List<Employee> chercherparnomEmployee(String nom){
		return employeeRepository.findByNomEmploye(nom);
	}
	@Override
	public List<Employee> chercherparnomEmployeeContains(String nom){
		return employeeRepository.findByNomEmployeContainingIgnoreCase(nom);
	}

	@Override
	public List<Employee> findBynometsalaire(String nom, int salaire) {
		
		return employeeRepository.findBynometsalaire(nom, salaire);
	}

	@Override
	public List<Employee> findByGrade(Grade grade) {
	
		return employeeRepository.findByGrade(grade);
	}

	@Override
	public List<Employee> findByGradeIdGraEmp(int id) {
		return employeeRepository.findByGradeIdGraEmp(id);
	}

	@Override
	public List<Employee> findByOrderByNomEmployeAsc() {
		
		return employeeRepository.findByOrderByNomEmployeAsc();
	}

	@Override
	public List<Employee> trierEmployeesNomsSalaire() {
		return employeeRepository.trierEmployeesNomsSalaire();
	}
	
}
