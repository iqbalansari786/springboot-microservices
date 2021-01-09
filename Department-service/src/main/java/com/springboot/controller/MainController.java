package com.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Department;
import com.springboot.services.DepartmentService;

import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/departments")
@Slf4j
public class MainController {
	
	
	@Autowired
	
	
	private DepartmentService departmentService;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department)
	{
		
		log.info("inside department save method called");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id")Long departmentId)
	{
		log.info("getting department by id controller called");
		
		return departmentService.findDepartmentById(departmentId);
	}
	
	
	

}
