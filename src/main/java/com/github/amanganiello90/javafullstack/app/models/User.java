package com.github.amanganiello90.javafullstack.app.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.amanganiello90.javafullstack.db.h2.models.UserJPA;
import com.github.amanganiello90.javafullstack.db.mongo.models.UserMongo;

/**
 *
 * @author amanganiello90
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
@JsonSubTypes({ @JsonSubTypes.Type(UserJPA.class), @JsonSubTypes.Type(UserMongo.class) })
public interface User {

	public String getId();

	public void setId(String id);

	public String getUserName();

	public void setUserName(String userName);

	public String getEmail();

	public void setEmail(String email);

	public String getFirstName();

	public void setFirstName(String firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public abstract User factory();

}
