/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.h2.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.github.amanganiello90.javafullstack.app.models.User;
import com.github.amanganiello90.javafullstack.app.repositories.UserRepository;
import com.github.amanganiello90.javafullstack.db.h2.models.UserJPA;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author amanganiello90
 */

@Repository
public class UserDAO implements UserRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private List<User> users;

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(UserJPA.class, id);
	}

	@Override
	@Transactional
	public User save(User user) {
		// TODO Auto-generated method stub
		User object = this.findById(user.getId());
		if (object != null) {
			if (object.getId().equals(user.getId())) {
				entityManager.merge(user);
				return user;
			}
		}
		entityManager.persist(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		// Query query = entityManager.createQuery("SELECT p FROM UserJPA p
		// ");
		TypedQuery<UserJPA> query = entityManager.createQuery("from UserJPA", UserJPA.class);
		users = new ArrayList<User>();
		List<UserJPA> getUsers = query.getResultList();
		for (int i = 0; i < getUsers.size(); i++) {
			users.add(getUsers.get(i));
		}
		return users;

	}

	@Override
	@Transactional
	public void delete(User user) {
		// TODO Auto-generated method stub
		entityManager.remove(user);

	}

}
