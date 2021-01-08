package com.springboot.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.entity.UserEntity;
import com.springboot.services.UserServices;

@RestController
@RequestMapping("/user")
public class MainController {
	
	private static Logger log = LoggerFactory.getLogger("MainController logger==>");
	
	@Autowired
	
	
	private UserServices userService;
	
	@GetMapping("/getAllUser")
	public List<UserEntity> getAllUser()
	{
		log.info("getting all user controller called");
		return userService.getAlluser();
	}
	@GetMapping("/getUserById/{id}")
	public UserEntity getUserById(@PathVariable("id")Long id)
	{
		return userService.getUserById(id).get();
	}
	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody UserEntity user)
	{log.info("creating  user controller called");
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}

}
