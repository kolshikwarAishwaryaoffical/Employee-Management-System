package com.example.loginadmin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginadmin.models.Employee;

import com.example.loginadmin.service.EmployeeService;



@RestController
@RequestMapping("/admin/employee")

public class EmployeeController {

	@Autowired
	private EmployeeService employeeService ;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getemployees")
	public List<Employee> getALLEmployee() {
		return employeeService.getAllEmployees();
		
	}
	@PutMapping("/{employeeEmailId}/manager/{managerEmailId}")
	public Employee assignManager(@PathVariable("employeeEmailId") String employeeEmailId,
			@PathVariable("managerEmailId") String managerEmailId) {
				return employeeService.assignManager(employeeEmailId,managerEmailId );
		
	}
}