package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	// load employee data
	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// add mapping for "/list"
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		List<Employee> theEmployees = employeeService.findAll();
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model to bind form data
		Employee theEmployee = new Employee();
		// add to the spring model
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int employeeId, Model theModel) {
		// retieve employee from employee service using id
		Employee theEmployee = employeeService.findById(employeeId);
		// add to the spring model to prepopulate the form
		theModel.addAttribute("employee", theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee employee){
		// save the employee
		employeeService.save(employee);
		// use a redirect to prevent the duplicate submissions
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int employeeId){
		// delete the employee
		employeeService.deleteById(employeeId);
		// use a redirect to prevent the duplicate submissions
		return "redirect:/employees/list";
	}
}









