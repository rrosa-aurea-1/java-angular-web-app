/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.app.controllers;

import com.github.amanganiello90.javafullstack.app.models.Product;
import com.github.amanganiello90.javafullstack.app.services.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amanganiello90
 */

@RestController
@RequestMapping(path="/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/products")
	public List<Product> products() {
		return productService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/products")
	public String save(@RequestBody Product product) {

		return productService.save(product);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
	public Product getProductById(@PathVariable String id) {
		return productService.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/products/{id}")
	public Product update(@PathVariable String id, @RequestBody Product product) {
		return productService.update(id, product);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/products/{id}")
	public String delete(@PathVariable String id) {
		return productService.delete(id);
	}
}