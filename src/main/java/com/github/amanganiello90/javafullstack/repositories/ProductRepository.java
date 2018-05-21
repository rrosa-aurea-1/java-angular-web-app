package com.github.amanganiello90.javafullstack.repositories;

import java.util.List;

import com.github.amanganiello90.javafullstack.models.Product;

public interface ProductRepository {
	
	public Product findById(String id);
	public Product save(Product prod);
	public List<Product> findAll();
	public void delete(Product prod);

}
