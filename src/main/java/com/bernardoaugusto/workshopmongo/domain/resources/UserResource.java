package com.bernardoaugusto.workshopmongo.domain.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bernardoaugusto.workshopmongo.DTO.UserDTO;
import com.bernardoaugusto.workshopmongo.domain.User;
import com.bernardoaugusto.workshopmongo.services.UserService;


@RestController 
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findALL();
		List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDTO);

	}
	
}
