/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.mongo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.github.amanganiello90.javafullstack.app.models.Product;

/**
 *
 * @author amanganiello90
 */

@Component
@Document(collection = "Products")
public class ProductMongo implements Product {

	@Id
	private String id;

	private String prodName;
	private String prodDesc;
	private Double prodPrice;
	private String prodImage;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getProdName() {
		return prodName;
	}

	@Override
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Override
	public String getProdDesc() {
		return prodDesc;
	}

	@Override
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	@Override
	public Double getProdPrice() {
		return prodPrice;
	}

	@Override
	public void setProdPrice(Double prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String getProdImage() {
		return prodImage;
	}

	@Override
	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	@Override
	public Product factory() {
		return new ProductMongo();
	}

}
