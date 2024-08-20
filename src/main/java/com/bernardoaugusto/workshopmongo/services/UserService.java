package com.bernardoaugusto.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardoaugusto.workshopmongo.domain.User;
import com.bernardoaugusto.workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findALL(){
		return repository.findAll();
	}
	
}
