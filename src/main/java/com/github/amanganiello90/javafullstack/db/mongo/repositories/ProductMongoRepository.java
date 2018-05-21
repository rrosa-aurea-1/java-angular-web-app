/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.amanganiello90.javafullstack.db.mongo.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.amanganiello90.javafullstack.models.Product;
import com.github.amanganiello90.javafullstack.repositories.ProductRepository;



/**
 *
 * @author amanganiello90
 */
public interface ProductMongoRepository extends MongoRepository<Product, String>, ProductRepository {


}
