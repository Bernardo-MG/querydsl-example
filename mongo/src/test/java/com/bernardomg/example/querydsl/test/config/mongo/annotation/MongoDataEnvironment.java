
package com.bernardomg.example.querydsl.test.config.mongo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import com.bernardomg.example.querydsl.test.config.mongo.extension.MongoCleanupExtension;
import com.bernardomg.example.querydsl.test.config.mongo.extension.MongoInitializationExtension;

/**
 * Marca un método para inicializar la base de datos Mongo. Tras su ejecución la
 * base de datos será limpiada.
 * 
 * @author bmg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(MongoCleanupExtension.class)
@ExtendWith(MongoInitializationExtension.class)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface MongoDataEnvironment {

}
