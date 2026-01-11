
https://www.coginiti.co/blog/the-evolution-of-sql-from-sql-86-to-sql-2023/

PostgreSQL: \
https://www.postgresql.org/download/ 

PostgreSQL Privileges: \
https://www.postgresql.org/docs/current/ddl-priv.html

UI-Client-DB Tools \
https://www.jetbrains.com/datagrip/ \
https://dbeaver.io/ \
https://www.pgadmin.org/

### RDBMS 

Sistem (System): Bu sadece bir dosya değil. Arka planda sürekli çalışan, RAM ve CPU tüketen, işletim sistemiyle 
konuşan karmaşık bir yazılımdır.


Yönetim (Management): Bu yazılımın en önemli kısmıdır.

- **Güvenlik:** Kim girebilir ? Kim veriyi görebilir ?
- **Bütünlük(Integrity):** Girilen veri kurallara uyuyor mu ?
- **Eşzamanlılık(Concurrency):** Aynı anda yapılan işlemler nasıl yönetilecek ? Örn: 1000 kişi aynı anda 
"Satın Al" butonuna basarsa ne olur?
- **Kurtarma:**: Veri nasıl kurtarılacak? (Elektrik kesintisin vb)

Veritabanı(Database): Verinin disk üzerindeki fiziksel hali. 
 Verinin Codd'un kurallarına göre organize edilmesi.


#### SQL
SQL, Structured Query Language, veritabanlarıyla (RDBMS) konuşmamızı sağlayan standart dildir.
Bir veritabanından veri çekmek, yeni kayıt eklemek veya veritabanının yapısını değiştirmek için bu dili kullanırız.

SQL, yaptığı işin niteliğine göre alt kategorilere ayrılır:

https://www.baeldung.com/sql/ddl-dml-dcl-tcl-differences


**1.DDL (Data Definition Language)**

Verinin kendisine değil, verinin organize edileceği iskelete,şemaya yöneliktir. Yapılan değişiklikler kalıcıdır. Genellikle 
geri alınamaz.

* CREATE: yeni bir veritabanı, tablo, index, view gibi yapılar oluşturur.
* ALTER: Mevcut bir yapıyı değiştirir.(Örn Tabloya kolon eklemek/çıkarmak, CONSTRAINT eklemek/kaldırmak)
* DROP: Bir yapıyı tamamen siler/yok eder.
* TRUNCATE: Tablonun içini tamamen boşaltır ama tabloyu (relation) yerinde bırakır.

**2.DML (Data Manipulation Language)** 

 Tabloların (relation), içindeki verilere yöneliktir. Günlük akışta en sık kullanılan dildir.

* SELECT: Verileri okur/listeler.
* INSERT: Yeni veri/satır/tuple ekler
* UPDATE: Mevcut veriyi günceller. (Bu güncelleme veritabanının stratejisine bağlıdır.)
* DELETE: Veriyi/Satırı/Tuple siler

**3.DCL (Data Control Language)** 

Veritabanına hangi kullanıcıların girip ne yapabileceklerini belirlemeye yöneliktir. 

* GRANT: Yetki verir
* REVOKE: Yetkiyi geri alır


**4. TCL (Transaction Control Language)**

DML işlemleri sırasında veri bütünlüğünü/tutarlılığını korumak için kullanılır. 

* COMMIT: Yapılan değişiklikleri kalıcı olarak kayıt eder.
* ROLLBACK: Yapılan değişiklikleri geri alır, işlemi iptal eder.
* SAVEPOINT: Geri dönülebilecek bir ara durak noktası belirler.
..

---


```sql
-- DDL
CREATE TABLE employee();
DROP TABLE employee;

-- DML
SELECT * FROM employee;


CREATE TABLE employee(
    first_name      VARCHAR(20),
    last_name       VARCHAR(20),
    ssn             VARCHAR(20)
);


SELECT * FROM employee;

-- DML
INSERT INTO employee VALUES ('John','Doe','SSN-1000');

-- Where Clause Predicate Logic
DELETE FROM employee WHERE ssn = 'SSN-1000';

```


### SQL JOIN 

```sql
SELECT * FROM ap.invoice_line_items;

SELECT * FROM ap.general_ledger_accounts;

SELECT COUNT(invoice_id) FROM ap.invoices;
SELECT COUNT(invoice_id) FROM ap.invoice_line_items;

SELECT * FROM ap.invoices, ap.invoice_line_items WHERE ap.invoices.invoice_id = ap.invoice_line_items.invoice_id;

-- 114 * 118
SELECT 114 * 118;

SELECT * FROM
             (ap.invoices i JOIN ap.invoice_line_items ili ON i.invoice_id = ili.invoice_id );

SELECT * FROM
    (ap.invoices i INNER JOIN ap.invoice_line_items ili ON i.invoice_id = ili.invoice_id );

SELECT * FROM ap.invoices, ap.invoice_line_items; -- CARTESIAN PRODUCT

SELECT * FROM ap.invoices CROSS JOIN ap.invoice_line_items;

```


```sql
-- Aşağıdaki iki sorgunun aynı çözüm kümesini üretteğine dikkat ediniz.
SELECT *
     FROM ap.general_ledger_accounts gla LEFT OUTER JOIN ap.invoice_line_items ili ON gla.account_number = ili.account_number
     WHERE ili.account_number IS NOT NULL;

SELECT *
FROM ap.general_ledger_accounts gla JOIN ap.invoice_line_items ili ON gla.account_number = ili.account_number;
```

> https://learn.microsoft.com/tr-tr/sql/relational-databases/query-processing-architecture-guide?view=sql-server-ver17
