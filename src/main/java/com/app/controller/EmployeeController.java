package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Employee;
import com.app.service.IEmployeeService;

@RestController // Mandatory @Controller (class level) + @ResponseBody - Marshalling
//i.e. all request method' retn type is annotateted with @ResponseBody
@RequestMapping("/api/employees")
@CrossOrigin(originPatterns = {"http://localhost:3000"})
public class EmployeeController {

	public EmployeeController() {
		System.out.println("inside emp controller ");
	}

	@Autowired
	private IEmployeeService empService;

	// add requesthandling method is (Rest API call) to send JSON list of employees
	@GetMapping
	public List<Employee> listAllEmp() {
		System.out.println(" getting all list in listAllEmp");

		return empService.getAllEmpDetail();
	}

	@PostMapping
	public Employee saveEmp(@RequestBody Employee emp) {
		// @RequestBody to perform unmarshall/deserialisation i.e. JSON to java object
		return empService.addNewEmployee(emp);
	}

	@DeleteMapping("/{id}")
	// as id is coming throgh path variable we need to use @pathVaiable
	public String deleteEmpDetails(@PathVariable int id) {
		return empService.deleteEmp(id);
	}

	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		System.out.println(" getting deetails by ID for updation or 2 way method binding ");
		return empService.getEmpDetails(id);
	}

	@PutMapping
	public Employee updationEmp(@RequestBody Employee emp) {
		return empService.updateEmp(emp);
	}
}
