package com.github.amanganiello90.javafullstack.app.repositories;

import java.util.List;

import com.github.amanganiello90.javafullstack.app.models.SimpleTime;

public interface SimpleTimeRepository {

	public SimpleTime findById(String id);

	public SimpleTime save(SimpleTime time);

	public List<SimpleTime> findAll();
}
