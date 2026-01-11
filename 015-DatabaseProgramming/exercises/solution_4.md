
```sql
SELECT now();
SELECT CURRENT_TIME;

SELECT CURRENT_DATE; -- YYYY-MM-DD

SELECT to_date(CURRENT_DATE || '', 'YYYY MM DD');

SELECT to_char(CURRENT_DATE, 'MM-DD-YYYY') AS "current_date";

```

https://www.postgresql.org/docs/18/functions-datetime.html#FUNCTIONS-DATETIME-CURRENT

https://www.postgresql.org/docs/18/functions-formatting.html

