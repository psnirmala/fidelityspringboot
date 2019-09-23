package com.fmr.training.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fmr.training.repository.Employee;
import com.fmr.training.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@RequestMapping(value="/{id}",produces={MediaType.APPLICATION_JSON_VALUE,
			MediaType.TEXT_HTML_VALUE})
	public ResponseEntity<?> getEmployeeDetails(@PathVariable("id")int empId)
	{
		Optional<Employee> opt=empService.getEmployeeDetails(empId);
		if(opt.isPresent()){
			return new ResponseEntity<Employee>(opt.get(), HttpStatus.OK);
		}
		else{
			String msg="<html><body><h2>No such employee with id "+empId+
					"</h2></body></html>";
			return new ResponseEntity<String>(msg,HttpStatus.BAD_REQUEST);
		}
	}
}
