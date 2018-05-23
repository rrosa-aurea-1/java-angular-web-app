package com.github.amanganiello90.javafullstack.db.h2.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.github.amanganiello90.javafullstack.app.models.User;

/**
 *
 * @author amanganiello90
 */
@Component
@Entity
@Table(name = "User")
public class UserJPA implements User, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;


	private String username;

	private String email;

	
	private String firstname;

	private String lastname;

	@Override
	public User factory() {
		// TODO Auto-generated method stub
		return new UserJPA();
	}

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
		return username;
	}

	@Override
	public void setUserName(String userName) {
		this.username = userName;
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
	public String getFirstName() {
		return firstname;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	@Override
	public String getLastName() {
		return lastname;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

}
