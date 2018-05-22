package com.github.amanganiello90.javafullstack.db.h2.models;

import java.io.Serializable;

import javax.persistence.Column;
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

	@Column(name = "username")
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "firstname")
	private Double firstName;

	@Column(name = "lastname")
	private String lastName;

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

}
