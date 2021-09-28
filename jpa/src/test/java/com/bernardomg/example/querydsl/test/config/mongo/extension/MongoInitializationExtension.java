
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
