package com.yassine.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import com.yassine.employee.Repository.GradeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yassine.employee.Repository.EmployeeRepository;
import com.yassine.employee.dto.EmployeeDTO;
import com.yassine.employee.entity.Employee;
import com.yassine.employee.entity.Grade;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private GradeRepository gradeRepository;

	//
	@Override
	public EmployeeDTO saveEmployee(EmployeeDTO dto) {
		return convertEntityToDto(
				employeeRepository.save(convertDtoToEntity(dto))
		);
	}
	@Autowired
	ModelMapper modelMapper;
	//  UPDATE
	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO dto) {
		return convertEntityToDto(
				employeeRepository.save(convertDtoToEntity(dto))
		);
	}

	// DELETE
	@Override
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
	}

	//  GET BY ID
	@Override
	public EmployeeDTO getEmployee(int id) {
		return convertEntityToDto(
				employeeRepository.findById(id).orElse(null)
		);
	}

	//  GET ALL
	@Override
	public List<EmployeeDTO> getAllEmployees() {
		return employeeRepository.findAll()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	//  SEARCH
	@Override
	public List<EmployeeDTO> chercherparnomEmployee(String nom) {
		return employeeRepository.findByNomEmploye(nom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> chercherparnomEmployeeContains(String nom) {
		return employeeRepository.findByNomEmployeContainingIgnoreCase(nom)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> findBynometsalaire(String nom, int salaire) {
		return employeeRepository.findBynometsalaire(nom, salaire)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> findByGrade(Grade grade) {
		return employeeRepository.findByGrade(grade)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> findByGradeIdGraEmp(int id) {
		return employeeRepository.findByGradeIdGraEmp(id)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> findByOrderByNomEmployeAsc() {
		return employeeRepository.findByOrderByNomEmployeAsc()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDTO> trierEmployeesNomsSalaire() {
		return employeeRepository.trierEmployeesNomsSalaire()
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	// CONVERT ENTITY -> DTO
	//@Override
//	public EmployeeDTO convertEntityToDto(Employee e) {
//		return EmployeeDTO.builder()
//				.idEmploye(e.getIdEmploye())
//				.nomEmploye(e.getNomEmploye())
//				.prenomEmploye(e.getPrenomEmploye())
//				.posteEmploye(e.getPosteEmploye())
//				.dateEmbauche(e.getDateEmbauche())
//				.salaire(e.getSalaire())
//				.email(e.getEmail())
//				.telephone(e.getTelephone())
//				//.adresse(e.getAdresse())
//				.nomGrade(e.getGrade().getNomGraEmp())
//				.build();
//	}

	// CONVERT DTO -> ENTITY
//	@Override
//	public Employee convertDtoToEntity(EmployeeDTO dto) {
//
//		Employee e = new Employee();
//
//		e.setIdEmploye(dto.getIdEmploye());
//		e.setNomEmploye(dto.getNomEmploye());
//		e.setPrenomEmploye(dto.getPrenomEmploye());
//		e.setPosteEmploye(dto.getPosteEmploye());
//		e.setDateEmbauche(dto.getDateEmbauche());
//		e.setSalaire(dto.getSalaire());
//		e.setEmail(dto.getEmail());
//		e.setTelephone(dto.getTelephone());
//		//e.setAdresse(dto.getAdresse());
//
//		// ⚠️ récupération du grade depuis DB
//		Grade grade = gradeRepository.findByNomGraEmp(dto.getNomGrade());
//		e.setGrade(grade);
//
//		return e;
	//}
	@Override
	public EmployeeDTO convertEntityToDto(Employee e) {

		modelMapper.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.LOOSE);

		EmployeeDTO dto = modelMapper.map(e, EmployeeDTO.class);



		return dto;
	}
	@Override
	public Employee convertDtoToEntity(EmployeeDTO dto) {

		Employee e = modelMapper.map(dto, Employee.class);

		return e;
	}
}