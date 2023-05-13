package com.employeeManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.employeeManage.Model.Employee;
import com.employeeManage.Service.ServiceImpl;

@Controller
public class EmpController {
	@Autowired
	ServiceImpl ser;

	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("listEmployees", ser.getAllEmp());
		return "index";
	}
	@GetMapping("/showEmployeeForm")
	public String showEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "newEmployee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		ser.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model) {
		Employee employee = ser.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value = "id") int id) {
		this.ser.deleteEmployeeById(id);
		return "redirect:/";
	}
}
