/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.h2.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.github.amanganiello90.javafullstack.db.h2.models.ProductJPA;
import com.github.amanganiello90.javafullstack.models.Product;
import com.github.amanganiello90.javafullstack.repositories.ProductRepository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author amanganiello90
 */

@Repository
public class ProductDAO implements ProductRepository {

	@PersistenceContext
	private EntityManager entityManager;
	private List<Product> products;

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return entityManager.find(ProductJPA.class, id);
	}

	@Override
	@Transactional
	public Product save(Product prod) {
		// TODO Auto-generated method stub
		Product object = this.findById(prod.getId());
		if (object != null) {
			if (object.getId().equals(prod.getId())) {
				entityManager.merge(prod);
				return prod;
			}
		}
		entityManager.persist(prod);
		return prod;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		// Query query = entityManager.createQuery("SELECT p FROM ProductJPA p
		// ");
		TypedQuery<ProductJPA> query = entityManager.createQuery("from ProductJPA", ProductJPA.class);
		products = new ArrayList<Product>();
		List<ProductJPA> prods = query.getResultList();
		for (int i = 0; i < prods.size(); i++) {
			products.add(prods.get(i));
		}
		return products;

	}

	@Override
	@Transactional
	public void delete(Product prod) {
		// TODO Auto-generated method stub
		entityManager.remove(prod);

	}

}
