package com.employeeManage.Service;

import java.util.List;

import com.employeeManage.Model.*;
public interface EmpService {
	List <Employee> getAllEmp();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(int id);
	 void deleteEmployeeById(int id);


}
