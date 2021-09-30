/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2021 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.querydsl.test.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import com.bernardomg.example.querydsl.mongo.model.PersistentExampleEntity;
import com.bernardomg.example.querydsl.mongo.model.QPersistentExampleEntity;
import com.bernardomg.example.querydsl.mongo.repository.ExampleEntityRepository;
import com.bernardomg.example.querydsl.test.config.mongo.annotation.MongoDataMultipleDocument;
import com.bernardomg.example.querydsl.test.config.mongo.annotation.MongoDataSingleDocument;
import com.bernardomg.example.querydsl.test.config.mongo.annotation.MongoPersistenceIntegrationTest;
import com.google.common.collect.Iterables;

@MongoPersistenceIntegrationTest
@DisplayName("Mongo queries")
@EnabledIf(expression = "#{'${persistence.database}'.equals('mongo')}",
        reason = "Requires MongoDB")
public class ITPersistentExampleEntityMongoRead {

    @Autowired
    private ExampleEntityRepository repository;

    /**
     * Default constructor.
     */
    public ITPersistentExampleEntityMongoRead() {
        super();
    }

    @Test
    @MongoDataSingleDocument
    public void testQuery() {
        Assertions.assertEquals(1, repository.count());
    }

    @Test
    @MongoDataMultipleDocument
    public void testQuery_Filter() {
        final QPersistentExampleEntity sample;
        final Iterable<PersistentExampleEntity> read;

        sample = QPersistentExampleEntity.persistentExampleEntity;

        read = repository.findAll(sample.name.eq("entity_02"));

        Assertions.assertEquals(1, Iterables.size(read));
    }

}
