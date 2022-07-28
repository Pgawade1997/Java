package com.app.service;

import java.util.List;

import com.app.pojos.Employee;

public interface IEmployeeService {
	
	List<Employee> getAllEmpDetail();
	
	Employee addNewEmployee(Employee transientEmp);
	
	String deleteEmp(int id);
	
	Employee getEmpDetails(int id);
	
	Employee updateEmp(Employee emp);
}
