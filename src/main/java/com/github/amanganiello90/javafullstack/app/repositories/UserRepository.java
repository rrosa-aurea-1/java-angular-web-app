package com.github.amanganiello90.javafullstack.app.repositories;

import java.util.List;

import com.github.amanganiello90.javafullstack.app.models.User;

public interface UserRepository {
	
	public User findById(String id);
	public User save(User user);
	public List<User> findAll();
	public void delete(User user);

}
