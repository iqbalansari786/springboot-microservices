package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.VO.ResponseTemplateVO;
import com.springboot.entity.User;
import com.springboot.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
private	UserService userService;
	
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user)
	{
		
		log.info("inside save user controller");
			return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserDepartment(@PathVariable("id")long userId)
	{
		
		return userService.getUserDepartment(userId);
	}
	
	
	
	
}
