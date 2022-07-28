package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EmployeeRepository;
import com.app.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmpDetail() {

		return empRepo.findAll();
	}

	@Override
	public Employee addNewEmployee(Employee transientEmp) {

		return empRepo.save(transientEmp);
	}// execution of this method convert transient to persistent pojos
		// hibbernate will perform dirty checking and will flush the data session.flush
		// on tx.commit
		// and returns the detached pojo instance to the caller

	@Override
	public String deleteEmp(int id) {
		String  msg="Failed to delete ";
		if(empRepo.existsById(id)) {
		empRepo.deleteById(id);
		msg=" deleted user with " +id;
		}
		
		return msg;
	}

	@Override
	public Employee getEmpDetails(int id) {
		
		return empRepo.findById(id).orElseThrow(() -> new RuntimeException("Resource not fund"));
	}

	@Override
	public Employee updateEmp(Employee emp) {
		
		return empRepo.save(emp);
	}

}
