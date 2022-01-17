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

package com.bernardomg.example.querydsl.test.integration.sql;

import java.lang.reflect.AnnotatedElement;
import java.util.List;

import javax.persistence.Table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.EnabledIf;

import com.bernardomg.example.querydsl.jpa.model.PersistentExampleEntity;
import com.bernardomg.example.querydsl.jpa.model.QPersistentExampleEntity;
import com.bernardomg.example.querydsl.test.config.jpa.annotation.JpaPersistenceIntegrationTest;
import com.querydsl.core.Tuple;
import com.querydsl.sql.RelationalPathBase;
import com.querydsl.sql.SQLQueryFactory;

@JpaPersistenceIntegrationTest
@DisplayName("SQL queries")
@EnabledIf(expression = "#{!'${test.environment}'.equals('mongo')}",
        reason = "Requires relational database")
public class ITPersistentExampleEntitySqlSelect {

    @Autowired
    private SQLQueryFactory queryFactory;

    /**
     * Default constructor.
     */
    public ITPersistentExampleEntitySqlSelect() {
        super();
    }

    @Test
    @DisplayName("Returns data")
    @Sql("/sql/test_entity_single.sql")
    public final void testCreate() {
        final QPersistentExampleEntity sample;
        final AnnotatedElement annotatedElement;
        final Table table;
        final RelationalPathBase<PersistentExampleEntity> path;
        final List<Tuple> read;

        sample = QPersistentExampleEntity.persistentExampleEntity;

        annotatedElement = sample.getAnnotatedElement();
        table = annotatedElement.getAnnotation(Table.class);
        path = new RelationalPathBase<>(sample.getType(), sample.getMetadata(),
            table.schema(), table.name());

        read = queryFactory.select(sample.id, sample.name)
            .from(path)
            .fetch();

        Assertions.assertEquals(1, read.size());
    }

}
