package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.VO.Department;
import com.springboot.VO.ResponseTemplateVO;
import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		return userRepo.save(user);
	}

	public ResponseTemplateVO getUserDepartment(long userId) {
		ResponseTemplateVO rv = new ResponseTemplateVO();
		User user = userRepo.findByUserId(userId);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);

		rv.setUser(user);
		rv.setDepartment(department);

		return rv;
	}

}
