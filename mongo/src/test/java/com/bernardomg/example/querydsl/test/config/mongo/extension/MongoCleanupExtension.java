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

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Extensión de JUnit 5 que limpia la base de datos Mongo tras cada test. Borra
 * todas las colecciones existentes, de manera que no quede ningún dato.
 * <p>
 * Se borra antes y después de cada test para controlar casos en los que no se
 * borra correctamente los datos entre tests. Por supuesto, esto significa que
 * esta extensión se ha de ejecutar antes de cualquier otra que inicialice
 * datos, o esos datos se perderán.
 * 
 * @author bmg
 * 
 */
public final class MongoCleanupExtension
        implements BeforeEachCallback, AfterEachCallback {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(MongoCleanupExtension.class);

    public MongoCleanupExtension() {
        super();
    }

    @Override
    public final void afterEach(final ExtensionContext context)
            throws Exception {
        cleanup(context);
    }

    @Override
    public final void beforeEach(final ExtensionContext context)
            throws Exception {
        cleanup(context);
    }

    public final void cleanup(final ExtensionContext context) throws Exception {
        final MongoOperations operations;
        final Iterable<String> collections;

        // Se adquieren las operaciones del contexto de Spring
        operations = SpringExtension.getApplicationContext(context)
                .getBean(MongoOperations.class);

        // Lee el listado de colecciones
        collections = operations.getCollectionNames();
        LOGGER.trace("Dropping collections: {}", collections);

        // Borra todas las colecciones
        for (final String name : collections) {
            operations.dropCollection(name);
        }
    }

}
