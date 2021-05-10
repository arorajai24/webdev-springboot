package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	UserService(){}

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	};
	
	public void saveUser(User user)
	{
		repo.save(user);
	}
	
	public Iterable<User> showUser()
	{
		return repo.findAll();
	}
	
	public Iterable<User> deleteUser(String username)
	{
		repo.deleteByUsername(username);
		return repo.findAll();
	}
	
	public User findUser(String username)
	{
		return repo.findByUsername(username);
	}
}
