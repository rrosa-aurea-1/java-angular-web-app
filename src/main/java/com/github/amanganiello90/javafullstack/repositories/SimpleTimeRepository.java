package com.github.amanganiello90.javafullstack.repositories;

import java.util.List;

import com.github.amanganiello90.javafullstack.models.SimpleTime;

public interface SimpleTimeRepository {

	public SimpleTime findById(String id);

	public SimpleTime save(SimpleTime time);

	public List<SimpleTime> findAll();
}
