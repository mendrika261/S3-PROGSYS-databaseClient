# Java DBMS project

This is the client CLI-Based Application of a database management system (DBMS) implemented in Java.
Server can be found <a href='https://github.com/mendrika261/database'>here</a>.

> This DBMS system was developed by students as part of a class project and should not be considered a fully-functional system.

## How to use

### Requirements
* Java Runtime Environment
* Command Line Interface - CLI
* Whatever Operating System

### Using the compiled .jar released
You can download the latest version on <a href='https://github.com/mendrika261/databaseClient/releases'>release section</a>.<br>
**Run:** `java -jar databaseClient.jar [host ipV4] [port]`<br>
**Args:** The ipv4 and port of the host

### Working query
**Be Aware!** <br>
- Syntax are not case-sensitive
- No semicolon at the end of a query
> Available comparison operator are `==`, `!=`, `<=`, `>=`, `<` and `>`.
    We use `=` for affectation like on update!

#### Creation
  * `CREATE TABLE table-name`: objects name like "database" are not allowed to be a table name.
  * `INSERT INTO table VALUES val1,val2...`
    <br>Don't forget to `COMMIT` after insertion, deletion and update or `ROLLBACK` if needed.

#### Selection
  * `DESC DATABASE` to view all existing relation
  * `DESC table-name` to view all field of a relation
  * `SELECT * FROM table`
  * `SELECT * FROM table WHERE col==value`
  * `SELECT col1,col2... FROM table ...`
  * `SELECT * FROM table1 JOIN table2 ON id==id ...`
  * `SELECT * FROM table1 UNION table2 ...`
  * `SELECT * FROM table1 INTERSECTS table2 ...`
  * `SELECT * FROM table1 MINUS table2 ...`
  * `SELECT * FROM table1 DIVIDED_BY table2 ...`
  * Sub-query works by using parentheses
    <br>eg: `SELECT * FROM table1 UNION (SELECT * FROM DIVIDE table2 BY table 3)`

#### Update
  * `UPDATE table SET col=value WHERE col1==value1`

#### Delete
  * `DROP TABLE table-name`
  * `DELETE FROM table`
  * `DELETE FROM table WHERE col=value`

#### Others
  * `EXIT` to stop the client
