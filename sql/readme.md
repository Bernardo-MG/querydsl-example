# Querydsl Example - SQL

## Generating the metamodel

```
mvn clean compile -pl sql -Dcodegen.skip=false
```

This requires a DB connection. By default it will use this one:

```
jdbc:mysql://localhost:3306/testdb?user=test&password=test&nullNamePatternMatchesAll=true
```

This is defined in the Maven property codegen.url.