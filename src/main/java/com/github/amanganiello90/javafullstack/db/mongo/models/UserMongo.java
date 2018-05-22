/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.github.amanganiello90.javafullstack.app.models.User;

/**
 *
 * @author amanganiello90
 */

@Component
@Document(collection = "Users")
public class UserMongo implements User {

	@Id
	private String id;

	private String userName;
	private String email;
	private Double firstName;
	private String lastName;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public Double getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(Double firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public User factory() {
		return new UserMongo();
	}

}
