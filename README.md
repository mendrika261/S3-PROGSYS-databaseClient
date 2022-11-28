# Client version of the database

## Execution

Download a released version <a href="https://github.com/mendrika261/databaseClient/releases/tag/AlphaTest">here</a> <br>
<b>Console:</b> `java -jar databaseClient.jar localhost 1234` <br>
<b>Args:</b> hostname and port of the server (<a href="https://github.com/mendrika261/database">Server can be download here</a>)

## Working query

- CREATE TABLE table COLS col1,col2...
- DROP TABLE table
- SELECT col1,col2,col3... FROM table
- SELECT col1,col2,col3... FROM table WHERE (1 condition)
- INSERT INTO table VALUES val1,val2,val3...
- DESC table / DESC (database)
- COMMIT
- ROLLBACK
- SELECT * FROM table
- UPDATE table SET col1=val1 WHERE (1 condition fac.)
- DELETE FROM table WHERE (1 condition fac.)
- SELECT * FROM table JOIN user ON id==id
- SELECT * FROM table JOIN user ON id==id WHERE (1 condition)
- (query1) UNION (query2)
- (query1) INTERSECTS (query1)
- DIFFERENCE table1 AND table2
- DIVIDE table1 BY table2
