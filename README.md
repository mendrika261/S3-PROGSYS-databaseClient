# Java DBMS project

This is the client CLI-Based Application of a database management system (DBMS) implemented in Java.
Server can be found <a href='https://github.com/mendrika261/database'>here</a>.

> Remember that it is just for educational use!

## How to use

### Requirements
* Java Runtime Environment
* Command Line Interface - CLI
* Whatever Operating System

### Using the compiled .jar released
You can download the latest version on <a href='https://github.com/mendrika261/database/releases'>release section</a>.<br>
**Run:** `java -jar databaseClient.jar [host ipV4] [port]`<br>
**Args:** The ipv4 and port of the host

### Working query
**Be Aware!** <br>
- Syntax are case-sensitive
- Don't use comma or any operators with space
- No semicolon at the end of a query
> Available comparison operator are `==`, `!=`, `<=`, `>=`, `<` and `>`.
    We use only `=` on update!

#### Creation
  * `CREATE TABLE table-name`
  * `INSERT INTO table VALUES val1,val2...`
    <br>Don't forget to `COMMIT` after insertion or `ROLLBACK` if needed.

#### Selection
  * `DESC DATABASE` to view all existing relation
  * `DESC TABLE table-name` to view all field of a relation
  * `SELECT * FROM table`
  * `SELECT * FROM table WHERE col==value`
  * `SELECT col1,col2... FROM table ...`
  * `SELECT * FROM table1 JOIN table2 ON id==id ...`
  * `SELECT * FROM table1 UNION table2 ...`
  * `SELECT * FROM table1 INTERSECTS table2 ...`
  * `SELECT * FROM DIFFERENCE table1 AND table2 ...`
  * `SELECT * FROM DIVIDE table1 BY table2 ...`
  * Sub-query works by using parentheses
    <br>eg: `SELECT * FROM table1 UNION (SELECT * FROM DIVIDE table2 BY table 3)`

#### Update
  * `UPDATE table SET col=value WHERE col1=value1`

#### Delete
  * `DROP TABLE table-name`
  * `DELETE FROM table`
  * `DELETE FROM table WHERE col=value`

#### Others
  * `EXIT` to stop the client