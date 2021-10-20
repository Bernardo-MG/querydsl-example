package com.bernardomg.example.querydsl.sql.metamodel;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QExampleEntities is a Querydsl query type for QExampleEntities
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QExampleEntities extends com.querydsl.sql.RelationalPathBase<QExampleEntities> {

    private static final long serialVersionUID = -745150446;

    public static final QExampleEntities exampleEntities = new QExampleEntities("example_entities");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public final com.querydsl.sql.PrimaryKey<QExampleEntities> primary = createPrimaryKey(id);

    public QExampleEntities(String variable) {
        super(QExampleEntities.class, forVariable(variable), "null", "example_entities");
        addMetadata();
    }

    public QExampleEntities(String variable, String schema, String table) {
        super(QExampleEntities.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QExampleEntities(String variable, String schema) {
        super(QExampleEntities.class, forVariable(variable), schema, "example_entities");
        addMetadata();
    }

    public QExampleEntities(Path<? extends QExampleEntities> path) {
        super(path.getType(), path.getMetadata(), "null", "example_entities");
        addMetadata();
    }

    public QExampleEntities(PathMetadata metadata) {
        super(QExampleEntities.class, metadata, "null", "example_entities");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("id").withIndex(1).ofType(Types.DECIMAL).withSize(5).notNull());
        addMetadata(name, ColumnMetadata.named("name").withIndex(2).ofType(Types.VARCHAR).withSize(50).notNull());
    }

}

