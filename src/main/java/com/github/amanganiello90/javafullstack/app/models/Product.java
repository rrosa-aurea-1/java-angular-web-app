package com.github.amanganiello90.javafullstack.app.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.amanganiello90.javafullstack.db.h2.models.ProductJPA;
import com.github.amanganiello90.javafullstack.db.mongo.models.ProductMongo;

/**
 *
 * @author amanganiello90
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = ProductJPA.class, name = "productJPA"), @Type(value = ProductMongo.class, name = "productMongo") })
public interface Product {

	public String getId();

	public void setId(String id);

	public String getProdName();

	public void setProdName(String prodName);

	public String getProdDesc();

	public void setProdDesc(String prodDesc);

	public Double getProdPrice();

	public void setProdPrice(Double prodPrice);

	public String getProdImage();

	public void setProdImage(String prodImage);

	public abstract Product factory();

}
