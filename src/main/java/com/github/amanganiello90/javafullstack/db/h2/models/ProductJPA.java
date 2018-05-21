package com.github.amanganiello90.javafullstack.db.h2.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.github.amanganiello90.javafullstack.app.models.Product;

/**
 *
 * @author amanganiello90
 */
@Component
@Entity
@Table(name = "Product")
public class ProductJPA implements Product, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@Column(name = "prodname")
	private String prodName;

	@Column(name = "proddesc")
	private String prodDesc;

	@Column(name = "prodprice")
	private Double prodPrice;

	@Column(name = "prodimage")
	private String prodImage;

	@Override
	public Product factory() {
		// TODO Auto-generated method stub
		return new ProductJPA();
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

}
