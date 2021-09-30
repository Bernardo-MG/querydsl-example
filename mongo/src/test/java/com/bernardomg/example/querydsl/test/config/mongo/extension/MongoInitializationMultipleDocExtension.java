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

package com.bernardomg.example.querydsl.test.config.mongo.extension;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObject;

/**
 * Extensión de JUnit 5 que inicializa la base de datos Mongo antes de cada
 * test.
 * 
 * @author bmg
 *
 */
public final class MongoInitializationMultipleDocExtension
        implements BeforeEachCallback {

    public MongoInitializationMultipleDocExtension() {
        super();
    }

    @Override
    public final void beforeEach(final ExtensionContext context)
            throws Exception {
        final MongoOperations operations;

        // Se adquieren las operaciones del contexto de Spring
        operations = SpringExtension.getApplicationContext(context)
                .getBean(MongoOperations.class);

        // Guarda los datos de test
        operations.save(
                BasicDBObject.parse("{ \"name\":\"entity_01\", \"id\":1 }"),
                "ExampleEntity");
        operations.save(
                BasicDBObject.parse("{ \"name\":\"entity_02\", \"id\":2 }"),
                "ExampleEntity");
        operations.save(
                BasicDBObject.parse("{ \"name\":\"entity_03\", \"id\":3 }"),
                "ExampleEntity");
        operations.save(
                BasicDBObject.parse("{ \"name\":\"entity_04\", \"id\":4 }"),
                "ExampleEntity");
        operations.save(
                BasicDBObject.parse("{ \"name\":\"entity_05\", \"id\":5 }"),
                "ExampleEntity");
    }

}
