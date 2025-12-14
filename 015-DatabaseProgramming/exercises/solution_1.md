```sql



SELECT 3 + 4;

SELECT
     invoice_due_date AS "Due Date",
     invoice_total AS "Invoice Total",
     invoice_total / 10 AS "10%",
     invoice_total * 1.1 AS "Plus 10%"
     FROM ap.invoices
 WHERE invoice_total >= 500 AND invoice_total <= 1000
 ORDER BY invoice_due_date DESC;


SELECT
    invoice_due_date AS "Due Date",
    invoice_total AS "Invoice Total",
    invoice_total / 10 AS "10%",
    invoice_total * 1.1 AS "Plus 10%"
FROM ap.invoices
WHERE invoice_total BETWEEN 500 AND 1000 -- INCLUSIVE
ORDER BY invoice_due_date DESC;

```


COMPARISON FUNCTIONS AND OPERATORS 

https://www.postgresql.org/docs/18/functions-comparison.html
