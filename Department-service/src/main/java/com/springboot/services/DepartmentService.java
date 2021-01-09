package com.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Department;
import com.springboot.repository.DepartmentRepository;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;

	public Department saveDepartment(Department department) {
	
		return departmentRepo.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		return departmentRepo.findByDepartmentId(departmentId);
	}


}
