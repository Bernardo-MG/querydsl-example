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

import java.nio.charset.Charset;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StreamUtils;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 * Extensión de JUnit 5 que inicializa la base de datos Mongo antes de cada
 * test.
 * 
 * @author bmg
 *
 */
public final class MongoInitializationExtension implements BeforeEachCallback {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MongoInitializationExtension.class);

    public MongoInitializationExtension() {
        super();
    }

    @Override
    public final void beforeEach(final ExtensionContext context)
            throws Exception {
        final MongoOperations operations;
        final DBObject data;
        final String json;
        final Resource jsonResource;

        // Se adquieren las operaciones del contexto de Spring
        operations = SpringExtension.getApplicationContext(context)
                .getBean(MongoOperations.class);

        // Se procesan los datos de test
        jsonResource = new ClassPathResource("json/centro_full.json");
        json = StreamUtils.copyToString(jsonResource.getInputStream(),
                Charset.defaultCharset());
        data = BasicDBObject.parse(json);

        LOGGER.trace("Saving into collection {}", "centros");
        LOGGER.trace("Saving: {}", data);

        // Guarda los datos de test
        operations.save(data, "centros");
    }

}
