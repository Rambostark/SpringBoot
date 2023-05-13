package com.employeeManage.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employeeManage.Model.Employee;
@Repository
public interface EmpRepository extends CrudRepository<Employee,Integer> {
	
}
