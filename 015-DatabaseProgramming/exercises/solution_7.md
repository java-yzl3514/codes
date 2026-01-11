```sql
SELECT v.vendor_name,
       v.default_account_number AS defualt_account,
       gla.account_description AS description
FROM
    (ap.vendors v INNER JOIN ap.general_ledger_accounts gla ON v.default_account_number = gla.account_number)
ORDER BY
    account_description, vendor_name;
```
