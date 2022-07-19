package com.example.music.MusicApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.MusicApplication.model.User;
import com.example.music.MusicApplication.repository.UserRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(path = "users")
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	
	@GetMapping("/get")
	public List<User> getUsers() {
		return repository.findAll();
	}
	@PostMapping("/add")
	public void createUser(@RequestBody User user) {
		repository.save(user);
		System.out.println(user);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public User deleteUser(@PathVariable("id") long id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent()) {
		repository.deleteById(id);
		System.out.println("User deleted Successfully");
		return user.get();
		}
		else {
			return null;
		}
	}
	@PutMapping(path = "/update")
	public void updateUser(@RequestBody User user) {
		repository.save(user);
		System.out.println("User Updated successfully");
	}
}
