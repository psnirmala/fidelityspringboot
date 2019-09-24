package com.fmr.training.restwithjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fmr.training.restwithjpa.domain.Employee;
import com.fmr.training.restwithjpa.repository.EmployeeRepository;



@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Optional<Employee> getEmployeeDetails(int id)
	{
		return repository.findById(id);
		
	}
	
	public List<Employee> getAllEmployees()
	{
		return repository.findAll();
	}

	public int addEmployee(Employee e)
	{
		
		Employee emp=repository.save(e);
		return emp.getEmpId();
	}
	
	public boolean updateEmployee(int id,Employee e)
	{
		Optional<Employee> opt=repository.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			emp.setName(e.getName());
			emp.setDesignation(e.getDesignation());
			emp.setSalary(e.getSalary());
			repository.save(emp);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean removeEmployee(int id)
	{
		
		Optional<Employee> opt=repository.findById(id);
				if(opt.isPresent()) {
					repository.delete(opt.get());
					return true;
				}
				else {
					return false;
				}
	}
}
