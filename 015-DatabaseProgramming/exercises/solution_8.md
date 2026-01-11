```sql

SELECT v.vendor_name,
       i.invoice_date,
       i.invoice_number,
       ili.invoice_sequence AS li_sequence,
       ili.line_item_amount AS li_amount
FROM ap.vendors v
         JOIN ap.invoices i ON v.vendor_id = i.vendor_id
         JOIN ap.invoice_line_items ili ON i.invoice_id = ili.invoice_id
ORDER BY vendor_name, invoice_date, invoice_number, invoice_sequence;
```
