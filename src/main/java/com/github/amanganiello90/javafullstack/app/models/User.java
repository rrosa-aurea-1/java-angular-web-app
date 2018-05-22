package com.github.amanganiello90.javafullstack.app.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.amanganiello90.javafullstack.db.h2.models.UserJPA;
import com.github.amanganiello90.javafullstack.db.mongo.models.UserMongo;

/**
 *
 * @author amanganiello90
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = UserJPA.class, name = "userJPA"), @Type(value = UserMongo.class, name = "userMongo") })
public interface User {

	public String getId();

	public void setId(String id);

	public String getUserName();

	public void setUserName(String userName);

	public String getEmail();

	public void setEmail(String email);

	public Double getFirstName();

	public void setFirstName(Double firstName);

	public String getLastName();

	public void setLastName(String lastName);

	public abstract User factory();

}
