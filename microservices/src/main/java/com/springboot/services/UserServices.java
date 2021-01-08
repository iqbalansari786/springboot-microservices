package com.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.UserEntity;
import com.springboot.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRep;

	public List<UserEntity> getAlluser() {
		
		return userRep.findAll();
	}

	public Optional<UserEntity> getUserById(Long id) {
		return userRep.findById(id);
	}

}
