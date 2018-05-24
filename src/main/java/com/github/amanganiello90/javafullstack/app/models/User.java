package com.github.amanganiello90.javafullstack.app.models;


/**
 *
 * @author amanganiello90
 */
public interface User {

	public String getId();

	public void setId(String id);

	public String getUsername();

	public void setUsername(String username);

	public String getEmail();

	public void setEmail(String email);

	public String getFirstname();

	public void setFirstname(String firstname);

	public String getLastname();

	public void setLastname(String lastname);

	public abstract User factory();

}
