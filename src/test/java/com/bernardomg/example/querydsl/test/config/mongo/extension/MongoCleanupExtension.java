
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
