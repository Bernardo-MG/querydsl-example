
package com.bernardomg.example.querydsl.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.bernardomg.example.querydsl.mongo.model.PersistentExampleEntity;

public interface ExampleEntityRepository
        extends MongoRepository<PersistentExampleEntity, String>,
        QuerydslPredicateExecutor<PersistentExampleEntity> {

}
