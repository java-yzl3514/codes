
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


#### NATURAL JOIN
 SQL-92 ile birlikte standart hale gelmiştir.
 
```NATURAL JOIN```, iki tabloda **aynı isme ve aynı veri tipine** sahip stütunları otomatik olarak bulur ve 
bu sütunlar üzerinden ```INNER JOIN``` işlemi yapar. Bu durumda geliştiricinin ```ON``` clause'unu belirtmesine 
gerek kalmaz.


```sql
CREATE TABLE public.employee
(
    first_name    VARCHAR(20),
    last_name     VARCHAR(20),
    ssn           VARCHAR(20),
    department_id INTEGER
);

CREATE TABLE public.department
(
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100),
    created_at      DATE
);

SELECT *
FROM department;

ALTER TABLE employee
    ADD COLUMN department_id INT;

ALTER TABLE employee
    ADD CONSTRAINT fk_department_id FOREIGN KEY (department_id) REFERENCES department (department_id);

-- ALTER TABLE employee DROP CONSTRAINT fk_department_id;


INSERT INTO department(department_id, department_name, created_at)
VALUES (1, 'Human Resources', CURRENT_DATE),
       (2, 'IT', CURRENT_DATE);

INSERT INTO employee(first_name, last_name, ssn, department_id)
VALUES ('John', 'Doe', 'SSN1', 2),
       ('Jane', 'Doe', 'SSN2', 1),
       ('Alice', 'Brown', 'SSN3', 2),
       ('George', 'Smith', 'SSN4', 1);


SELECT *
FROM employee
         NATURAL JOIN department;
```
```NATURAL JOIN``` foreign key constraint şartı aramaz. Yukarıdaki örnekte employee ve department 
relation'ları foreign key constraint ile oluşturuluyor. Yorum satırını kaldırıp ilgili constraint'i 
kaldırarak sonucu tekrar gözlemleyiniz.

> NATURAL JOIN kullanımı **risklidir.** Özellikle uygulama katmanında bulunmaması gereken sorgu tipidir.
> Çünkü NATURAL JOIN körü körüne isim eşleşmesi yapar.
> 
> **Exercise:** Lütfen yukarıdaki örnekte, employee tablosuna created_at sütunu ekleyerek değerlerini de department tablosundaki
> create_at değerlerinden farklı yaparak, NATURAL JOIN sorgusunu tekrar çalıştırıp gözlemleyiniz.
> 

#### AGGREGATE FUNCTIONS
 * COUNT()
 * SUM()
 * AVG()
 * MIN()
 * MAX()

#### GROUP BY & HAVING

```sql
SELECT COUNT(department_id), department_id
FROM employee
GROUP BY department_id;

SELECT COUNT(e.department_id) AS employee_count,
       d.department_name
FROM employee e
         JOIN department d ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name;


SELECT *
FROM (SELECT COUNT(e.department_id) AS employee_count,
             d.department_name
      FROM employee e
               JOIN department d ON e.department_id = d.department_id
      GROUP BY e.department_id, d.department_name) t
WHERE employee_count > 2;


SELECT COUNT(e.department_id) AS employee_count,
       d.department_name
FROM employee e
         JOIN department d ON e.department_id = d.department_id
GROUP BY e.department_id, d.department_name
HAVING COUNT(e.department_id) > 2;
```

### SQL-92
 * CASE
 * CAST
 * INTERSECT
 * EXCEPT
 * IN
 * EXISTS

### SQL-99
 * ROLLUP
 * CUBE
 * WITH

### SQL-2003 - Critical 
 * OVER()
 * PARTITION BY
 
Sorun: ```GROUP BY``` kullanıldığında detay satırları kaybettiğimiz yukarıdaki sorgudan görebilirsiniz. Satırlar sıkışır 
ve tek satır olur.Bu noktada çözüm **OVER()** ve **PARTITION BY** olarak sunulmuştur.
Bu yapı daraltmadan özet bilgi eklenmesini sağlıyor.


```sql
CREATE TABLE cloud_usage_logs
(
    log_id          SERIAL PRIMARY KEY,
    service_name    VARCHAR(50),
    region          VARCHAR(20),
    usage_date      DATE,
    cpu_usage_hours INT,
    cost_amount     NUMERIC(10, 2)
);

SELECT *
FROM cloud_usage_logs;

INSERT INTO cloud_usage_logs(service_name, region, usage_date, cpu_usage_hours, cost_amount)
VALUES
-- us-east1 region
('Google Maps', 'us-east1', '2023-10-01', 100, 500.00),
('Google Maps', 'us-east1', '2023-10-02', 120, 600.00),
('Youtube', 'us-east1', '2023-10-01', 500,2500.00),
('Youtube', 'us-east1', '2023-10-02', 550,2750.00),
--europe-west1
('Google Maps', 'europe-west1', '2023-10-01', 80,400.00),
('Google Drive', 'europe-west1', '2023-10-01', 200,1000.00),
('Google Drive', 'europe-west1', '2023-10-02', 210,1050.00),
--asia-south1
('Youtube', 'asia-south1', '2023-10-01', 300,1500.00),
('Google Drive', 'asia-south1', '2023-10-01', 150,750.00);
```
>**Problem.0:** Hangi servis toplamda ne kadar fatura çıkardı? \
>**Problem.0.1:** Sadece 2000 (para)'yı geçenleri listeleyin
> 
> **Problem.1:** Önce bölge toplamını, onun altında servislerin toplamını; en altta da şirket genel toplamı raporunu çıkarın.
> **Problem.2:** Yönetimiz bizden şöyle bir rapor istemiş olsun: 
> 
> "Olası tüm açılardan bakmak istiyorum.Buna göre:"
> - Bölge toplamları nedir?
> - Servis toplamları nedir?
> - Bölge + Servis toplamları nedir? \
> "Lütfen hepsi bir tabloda olsun"
> 
> **Problem.3:** Yöneticimiz şöyle bir rapor istemiş olsun: 
> 
> "Her bir işlem satırını 'açıkça' görmek istiyorum ama, yanında o işlemin yapıldığı bölgenin toplam harcamasını da 
> görmek istiyorum.Böylece ilgili işlemin bölge içindeki payını anlayabileceğim"
> 
> **Problem.4:** "Bana her bölgedeki en pahalı servisi bulan bir sorgu yazınız" (İpuucu: RANK)

```sql
-- Problem.0
SELECT
      service_name,
      SUM(cost_amount) AS total_cost
FROM cloud_usage_logs
GROUP BY service_name;

-- Problem.0.1 (Sıralama eklenmiştir)
SELECT
 service_name,
 SUM(cost_amount) AS total_cost
FROM cloud_usage_logs
GROUP BY service_name
HAVING SUM(cost_amount) > 2000
ORDER BY total_cost;

--Problem.1
SELECT region,
       service_name,
       SUM(cost_amount) AS total_cost
FROM cloud_usage_logs
GROUP BY ROLLUP (region, service_name)
ORDER BY region,service_name;

-- Problem.2
SELECT region,
       service_name,
       SUM(cost_amount) AS total_cost
FROM cloud_usage_logs
GROUP BY CUBE (region, service_name);

-- Problem.3
SELECT service_name,
       region,
       cost_amount                                 AS transaction_cost,
       SUM(cost_amount) OVER (PARTITION BY region) AS region_total_cost,
       to_char(ROUND(cost_amount / SUM(cost_amount) OVER (PARTITION BY region) * 100, 2), '99.99%') AS percantage_share
FROM cloud_usage_logs;

-- https://www.postgresql.org/docs/8.1/functions-formatting.html

--Problem.4

WITH region_cost_rank AS (SELECT service_name,
                                 region,
                                 cost_amount,
                                 RANK() OVER (PARTITION BY region ORDER BY cost_amount DESC) AS cost_rank
                          FROM cloud_usage_logs)
SELECT service_name,
       region,
       cost_amount
FROM region_cost_rank
WHERE cost_rank = 1;
```

#### CTE

https://www.postgresql.org/docs/current/queries-with.html

> **SELECT *'**: uzak durunuz 
> Kural: Daima ihtiyacınız olan sütunları açıkça yazınız.
> EXPLAIN ANALYZE komutunu PostgreSQL için kullanın
> JSONB


```sql



CREATE TABLE student(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

SELECT * FROM employee;

INSERT INTO employee(first_name, last_name, ssn, department_id)
VALUES (null, null, null, null);


EXPLAIN SELECT first_name, last_name FROM employee WHERE last_name = 'Doe';
-- B-Tree
CREATE INDEX idx_emp_last_name ON employee(last_name);

INSERT INTO student(name, email)
VALUES ('Adam Smith', 'adamsmith@email.com');

SELECT * FROM student;

EXPLAIN SELECT student.name FROM student WHERE id = 2;

CREATE INDEX idx_std_email ON student(email);

```
