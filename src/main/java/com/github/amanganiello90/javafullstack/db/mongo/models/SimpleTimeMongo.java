/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.github.amanganiello90.javafullstack.app.models.SimpleTime;

/**
 *
 * @author amanganiello90
 */

@Component
@Document(collection = "Times")
public class SimpleTimeMongo implements SimpleTime {

	@Id
	private String id;
	
	private String value;

	@Override
	public SimpleTime factory() {
		return new SimpleTimeMongo();
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
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
