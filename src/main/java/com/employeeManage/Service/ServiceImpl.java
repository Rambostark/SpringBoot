package com.employeeManage.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManage.Model.Employee;
import com.employeeManage.Repo.EmpRepository;
@Service
public class ServiceImpl implements EmpService {
	@Autowired
	EmpRepository repo;

	public List<Employee> getAllEmp() {

		return (List<Employee>) repo.findAll();
	}

	public void saveEmployee(Employee employee) {
		this.repo.save(employee);
	}

	public Employee getEmployeeById(int id) {
		Optional < Employee > optional = repo.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	public void deleteEmployeeById(int id) {
		this.repo.deleteById(id);
	}
}
