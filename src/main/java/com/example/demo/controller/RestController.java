package com.example.demo.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;


@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private UserService  service;
	
	@PostMapping("/save-user")
	@Transactional
	public String registerUser(@RequestBody User user)
		{
			service.saveUser(user);
			return "Hello " + user.getFname() + ", your reg is success!";
		}
	
	@GetMapping("/all-users")
	public Iterable<User> showall()
	{
		return service.showUser();
	}
	
	@GetMapping("/delete-user/{username}")
	@Transactional
	public Iterable<User> delete(@PathVariable String username)
	{
		return service.deleteUser(username);
	}
	
	@GetMapping("/search-user/{username}")
	@Transactional
	public User search(@PathVariable String username)
	{
		return service.findUser(username);
	}
}
