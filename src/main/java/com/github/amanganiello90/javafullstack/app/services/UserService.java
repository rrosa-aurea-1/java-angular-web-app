package com.github.amanganiello90.javafullstack.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.amanganiello90.javafullstack.app.models.User;
import com.github.amanganiello90.javafullstack.app.repositories.UserRepository;

/**
 *
 * @author amanganiello90
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	User user;

	public User findById(String id) {
		return userRepository.findById(id);
	}

	public String save(User user) {
		userRepository.save(user);
		return user.getId();
	}

	public List<User> findAll() {
		return userRepository.findAll();

	}

	public User update(String id, User user) {

		user.setId(id);

		this.save(user);
		return user;
	}

	public String delete(String id) {
		User user = this.findById(id);
		userRepository.delete(user);
		return "user deleted with id: " + id;
	}
}
