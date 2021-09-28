
package com.bernardomg.example.querydsl.test.config.mongo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

import com.bernardomg.example.querydsl.test.config.mongo.extension.MongoCleanupExtension;

/**
 * Marca un test para limpiar la base de datos Mongo tras su ejecución.
 * 
 * @author bmg
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(MongoCleanupExtension.class)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface MongoDataCleanup {

}
