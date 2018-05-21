package com.github.amanganiello90.javafullstack.db.mongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.github.amanganiello90.javafullstack.app.repositories.SimpleTimeRepository;

/**
 *
 * @author amanganiello90
 */
public interface SimpleTimeMongoRepository extends MongoRepository<SimpleTime, String>, SimpleTimeRepository {

}
