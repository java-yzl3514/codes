
```sql
SELECT gla.account_number, gla.account_description, ili.invoice_id
     FROM ap.general_ledger_accounts gla LEFT OUTER JOIN ap.invoice_line_items ili ON gla.account_number = ili.account_number
     WHERE ili.invoice_id IS NULL;

-- removes the invoice_id column from SELECT clause
SELECT gla.account_number, gla.account_description
FROM ap.general_ledger_accounts gla LEFT OUTER JOIN ap.invoice_line_items ili ON gla.account_number = ili.account_number
WHERE ili.invoice_id IS NULL;

-- order by account_number column
SELECT gla.account_number, gla.account_description
FROM ap.general_ledger_accounts gla LEFT OUTER JOIN ap.invoice_line_items ili ON gla.account_number = ili.account_number
WHERE ili.invoice_id IS NULL
ORDER BY gla.account_number;
```
