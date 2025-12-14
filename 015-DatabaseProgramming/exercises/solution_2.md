
```sql

SELECT vendor_contact_last_name || ', ' || vendor_contact_first_name AS full_name
   FROM ap.vendors
WHERE vendor_contact_last_name < 'D' OR vendor_contact_last_name LIKE 'E%'
ORDER BY vendor_contact_last_name, vendor_contact_first_name;


SELECT vendor_contact_last_name || ', ' || vendor_contact_first_name AS full_name
FROM ap.vendors
WHERE vendor_contact_last_name < 'D' OR vendor_contact_last_name LIKE 'E___'
ORDER BY vendor_contact_last_name, vendor_contact_first_name;

SELECT concat(vendor_contact_last_name, ', ', vendor_contact_first_name) AS full_name
FROM ap.vendors
ORDER BY vendor_contact_last_name, vendor_contact_first_name;

```
