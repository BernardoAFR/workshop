package com.bernardoaugusto.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bernardoaugusto.workshopmongo.DTO.UserDTO;
import com.bernardoaugusto.workshopmongo.domain.User;
import com.bernardoaugusto.workshopmongo.repository.UserRepository;
import com.bernardoaugusto.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findALL(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User obj) {
		User userUp = findById(obj.getId());
		updateData(userUp, obj);
		return repository.save(userUp);
		}

	private void updateData(User userUp, User obj) {
		userUp.setName(obj.getName());
		userUp.setEmail(obj.getEmail());
	}
}
