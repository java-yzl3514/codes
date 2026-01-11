```sql

SELECT v.vendor_name,
       i.invoice_number,
       i.invoice_date,
       i.invoice_total - i.payment_total - i.credit_total AS balance_due
FROM
      (ap.vendors v INNER JOIN ap.invoices i ON v.vendor_id = i.vendor_id )
WHERE
      (i.invoice_total - i.payment_total - i.credit_total) <> 0
ORDER BY
      v.vendor_name;
```
