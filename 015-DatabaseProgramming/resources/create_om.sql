-- ********************************************
-- CREATE THE Order Management DATABASE
-- *******************************************

CREATE SCHEMA om AUTHORIZATION YOUR_DB_USER;

-- create database
--DROP DATABASE IF EXISTS om;
--CREATE DATABASE om;

-- select database
--\connect om;

-- create tables
CREATE TABLE om.customers
(
  customer_id           INT             NOT NULL,
  customer_first_name   VARCHAR(50),
  customer_last_name    VARCHAR(50)     NOT NULL,
  customer_address      VARCHAR(255)    NOT NULL,
  customer_city         VARCHAR(50)     NOT NULL,
  customer_state        CHAR(2)         NOT NULL,
  customer_zip          VARCHAR(20)     NOT NULL,
  customer_phone        VARCHAR(30)     NOT NULL,
  customer_fax          VARCHAR(30),
  CONSTRAINT customers_pk
    PRIMARY KEY (customer_id)
);

CREATE TABLE om.items
(
  item_id       INT             NOT NULL,
  title         VARCHAR(50)     NOT NULL,
  artist        VARCHAR(50)     NOT NULL,
  unit_price    DECIMAL(9,2)    NOT NULL,
  CONSTRAINT items_pk
    PRIMARY KEY (item_id),
  CONSTRAINT title_artist_unq
    UNIQUE (title, artist)
);

CREATE TABLE om.orders
(
  order_id          INT         NOT NULL,
  customer_id       INT         NOT NULL,
  order_date        DATE        NOT NULL,
  shipped_date      DATE,
  CONSTRAINT orders_pk
    PRIMARY KEY (order_id),
  CONSTRAINT orders_fk_customers
    FOREIGN KEY (customer_id) REFERENCES om.customers (customer_id)
);

CREATE TABLE om.order_details
(
  order_id      INT           NOT NULL,
  item_id       INT           NOT NULL,
  order_qty     INT           NOT NULL,
  CONSTRAINT order_details_pk
    PRIMARY KEY (order_id, item_id),
  CONSTRAINT order_details_fk_orders
    FOREIGN KEY (order_id)
    REFERENCES om.orders (order_id),
  CONSTRAINT order_details_fk_items
    FOREIGN KEY (item_id)
    REFERENCES om.items (item_id)
);

-- insert rows into tables
INSERT INTO om.customers VALUES (1,'Korah','Blanca','1555 W Lane Ave','Columbus','OH','43221','6145554435');
INSERT INTO om.customers VALUES (2,'Yash','Randall','11 E Rancho Madera Rd','Madison','WI','53707','2095551205');
INSERT INTO om.customers VALUES (3,'Johnathon','Millerton','60 Madison Ave','New York','NY','10010','2125554800');
INSERT INTO om.customers VALUES (4,'Mikayla','Damion','2021 K Street Nw','Washington','DC','20006','2025555561');
INSERT INTO om.customers VALUES (5,'Kendall','Mayte','4775 E Miami River Rd','Cleves','OH','45002','5135553043');
INSERT INTO om.customers VALUES (6,'Kaitlin','Hostlery','3250 Spring Grove Ave','Cincinnati','OH','45225','8005551957');
INSERT INTO om.customers VALUES (7,'Derek','Chaddick','9022 E Merchant Wy','Fairfield','IA','52556','5155556130');
INSERT INTO om.customers VALUES (8,'Deborah','Damien','415 E Olive Ave','Fresno','CA','93728','5595558060');
INSERT INTO om.customers VALUES (9,'Karina','Lacy','882 W Easton Wy','Los Angeles','CA','90084','8005557000');
INSERT INTO om.customers VALUES (10,'Kurt','Nickalus','28210 N Avenue Stanford','Valencia','CA','91355','8055550584');
INSERT INTO om.customers VALUES (11,'Kelsey','Eulalia','7833 N Ridge Rd','Sacramento','CA','95887','2095557500');
INSERT INTO om.customers VALUES (12,'Anders','Rohansen','12345 E 67th Ave NW','Takoma Park','MD','24512','3385556772');
INSERT INTO om.customers VALUES (13,'Thalia','Neftaly','2508 W Shaw Ave','Fresno','CA','93711','5595556245');
INSERT INTO om.customers VALUES (14,'Gonzalo','Keeton','12 Daniel Road','Fairfield','NJ','07004','2015559742');
INSERT INTO om.customers VALUES (15,'Ania','Irvin','1099 N Farcourt St','Orange','CA','92807','7145559000');
INSERT INTO om.customers VALUES (16,'Dakota','Baylee','1033 N Sycamore Ave.','Los Angeles','CA','90038','2135554322');
INSERT INTO om.customers VALUES (17,'Samuel','Jacobsen','3433 E Widget Ave','Palo Alto','CA','92711','4155553434');
INSERT INTO om.customers VALUES (18,'Justin','Javen','828 S Broadway','Tarrytown','NY','10591','8005550037');
INSERT INTO om.customers VALUES (19,'Kyle','Marissa','789 E Mercy Ave','Phoenix','AZ','85038','9475553900');
INSERT INTO om.customers VALUES (20,'Erick','Kaleigh','Five Lakepointe Plaza, Ste 500','Charlotte','NC','28217','7045553500');
INSERT INTO om.customers VALUES (21,'Marvin','Quintin','2677 Industrial Circle Dr','Columbus','OH','43260','6145558600');
INSERT INTO om.customers VALUES (22,'Rashad','Holbrooke','3467 W Shaw Ave #103','Fresno','CA','93711','5595558625');
INSERT INTO om.customers VALUES (23,'Trisha','Anum','627 Aviation Way','Manhatttan Beach','CA','90266','3105552732');
INSERT INTO om.customers VALUES (24,'Julian','Carson','372 San Quentin','San Francisco','CA','94161','6175550700');
INSERT INTO om.customers VALUES (25,'Kirsten','Story','2401 Wisconsin Ave NW','Washington','DC','20559','2065559115');

INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (1,'Umami In Concert','Umami',17.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (2,'Race Car Sounds','The Ubernerds',13);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (3,'No Rest For The Weary','No Rest For The Weary',16.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (4,'More Songs About Structures and Comestibles','No Rest For The Weary',17.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (5,'On The Road With Burt Ruggles','Burt Ruggles',17.5);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (6,'No Fixed Address','Sewed the Vest Pocket',16.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (7,'Rude Noises','Jess & Odie',13);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (8,'Burt Ruggles: An Intimate Portrait','Burt Ruggles',17.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (9,'Zone Out With Umami','Umami',16.95);
INSERT INTO om.items (item_id,title,artist,unit_price) VALUES (10,'Etcetera','Onn & Onn',17);

--INSERT INTO orders VALUES
INSERT INTO om.orders VALUES (19, 1, '2012-10-23', '2012-10-28');
INSERT INTO om.orders VALUES (29, 8, '2012-11-05', '2012-11-11');
INSERT INTO om.orders VALUES (32, 11, '2012-11-10', '2012-11-13');
INSERT INTO om.orders VALUES (45, 2, '2012-11-25', '2012-11-30');
INSERT INTO om.orders VALUES (70, 10, '2012-12-28', '2013-01-07');
INSERT INTO om.orders VALUES (89, 22, '2013-01-20', '2013-01-22');
INSERT INTO om.orders VALUES (97, 20, '2013-01-29', '2013-02-02');
INSERT INTO om.orders VALUES (118, 3, '2013-02-24', '2013-02-28');
INSERT INTO om.orders VALUES (144, 17, '2013-03-21', '2013-03-29');
INSERT INTO om.orders VALUES (158, 9, '2013-04-04', '2013-04-20');
INSERT INTO om.orders VALUES (165, 14, '2013-04-11', '2013-04-13');
INSERT INTO om.orders VALUES (180, 24, '2013-04-25', '2013-05-30');
INSERT INTO om.orders VALUES (231, 15, '2013-06-14', '2013-06-22');
INSERT INTO om.orders VALUES (242, 23, '2013-06-24', '2013-07-06');
INSERT INTO om.orders VALUES (264, 9, '2013-07-15', '2013-07-18');
INSERT INTO om.orders VALUES (298, 18, '2013-08-18', '2013-09-22');
INSERT INTO om.orders VALUES (321, 2, '2013-09-09', '2013-10-05');
INSERT INTO om.orders VALUES (381, 7, '2013-11-08', '2013-11-16');
INSERT INTO om.orders VALUES (392, 19, '2013-11-16', '2013-11-23');
INSERT INTO om.orders VALUES (413, 17, '2013-12-05', '2014-01-11');
INSERT INTO om.orders VALUES (442, 5, '2013-12-28', '2014-01-03');
INSERT INTO om.orders VALUES (479, 1, '2014-01-30', '2014-03-03');
INSERT INTO om.orders VALUES (491, 16, '2014-02-08', '2014-02-14');
INSERT INTO om.orders VALUES (494, 4, '2014-02-10', '2014-02-14');
INSERT INTO om.orders VALUES (523, 3, '2014-03-07', '2014-03-15');
INSERT INTO om.orders VALUES (548, 2, '2014-03-22', '2014-04-18');
INSERT INTO om.orders VALUES (550, 17, '2014-03-23', '2014-04-03');
INSERT INTO om.orders VALUES (601, 16, '2014-04-21', '2014-04-27');
INSERT INTO om.orders VALUES (606, 6, '2014-04-25', '2014-05-02');
INSERT INTO om.orders VALUES (607, 20, '2014-04-25', '2014-05-04');
INSERT INTO om.orders VALUES (624, 2, '2014-05-04', '2014-05-09');
INSERT INTO om.orders VALUES (627, 17, '2014-05-05', '2014-05-10');
INSERT INTO om.orders VALUES (630, 20, '2014-05-08', '2014-05-18');
INSERT INTO om.orders VALUES (631, 21, '2014-05-09', '2014-05-11');
INSERT INTO om.orders VALUES (651, 12, '2014-05-19', '2014-06-02');
INSERT INTO om.orders VALUES (658, 12, '2014-05-23', '2014-06-02');
INSERT INTO om.orders VALUES (687, 17, '2014-06-05', '2014-06-08');
INSERT INTO om.orders VALUES (693, 9, '2014-06-07', '2014-06-19');
INSERT INTO om.orders VALUES (703, 19, '2014-06-12', '2014-06-19');
INSERT INTO om.orders VALUES (773, 25, '2014-07-11', '2014-07-13');
INSERT INTO om.orders VALUES (778, 13, '2014-07-12', '2014-07-21');
INSERT INTO om.orders VALUES (796, 17, '2014-07-19', '2014-07-26');
INSERT INTO om.orders VALUES (800, 19, '2014-07-21', '2014-07-28');
INSERT INTO om.orders VALUES (802, 2, '2014-07-21', '2014-07-31');
INSERT INTO om.orders VALUES (824, 1, '2014-08-01', NULL);
INSERT INTO om.orders VALUES (827, 18, '2014-08-02', NULL);
INSERT INTO om.orders VALUES (829, 9, '2014-08-02', NULL);

INSERT INTO om.order_details VALUES (381,1,1);
INSERT INTO om.order_details VALUES (601,9,1);
INSERT INTO om.order_details VALUES (442,1,1);
INSERT INTO om.order_details VALUES (523,9,1);
INSERT INTO om.order_details VALUES (630,5,1);
INSERT INTO om.order_details VALUES (778,1,1);
INSERT INTO om.order_details VALUES (693,10,1);
INSERT INTO om.order_details VALUES (118,1,1);
INSERT INTO om.order_details VALUES (264,7,1);
INSERT INTO om.order_details VALUES (607,10,1);
INSERT INTO om.order_details VALUES (624,7,1);
INSERT INTO om.order_details VALUES (658,1,1);
INSERT INTO om.order_details VALUES (800,5,1);
INSERT INTO om.order_details VALUES (158,3,1);
INSERT INTO om.order_details VALUES (321,10,1);
INSERT INTO om.order_details VALUES (687,6,1);
INSERT INTO om.order_details VALUES (827,6,1);
INSERT INTO om.order_details VALUES (144,3,1);
INSERT INTO om.order_details VALUES (264,8,1);
INSERT INTO om.order_details VALUES (479,1,2);
INSERT INTO om.order_details VALUES (630,6,2);
INSERT INTO om.order_details VALUES (796,5,1);
INSERT INTO om.order_details VALUES (97,4,1);
INSERT INTO om.order_details VALUES (601,5,1);
INSERT INTO om.order_details VALUES (773,10,1);
INSERT INTO om.order_details VALUES (800,1,1);
INSERT INTO om.order_details VALUES (29,10,1);
INSERT INTO om.order_details VALUES (70,1,1);
INSERT INTO om.order_details VALUES (97,8,1);
INSERT INTO om.order_details VALUES (165,4,1);
INSERT INTO om.order_details VALUES (180,4,1);
INSERT INTO om.order_details VALUES (231,10,1);
INSERT INTO om.order_details VALUES (392,8,1);
INSERT INTO om.order_details VALUES (413,10,1);
INSERT INTO om.order_details VALUES (491,6,1);
INSERT INTO om.order_details VALUES (494,2,1);
INSERT INTO om.order_details VALUES (606,8,1);
INSERT INTO om.order_details VALUES (607,3,1);
INSERT INTO om.order_details VALUES (651,3,1);
INSERT INTO om.order_details VALUES (703,4,1);
INSERT INTO om.order_details VALUES (796,2,1);
INSERT INTO om.order_details VALUES (802,2,1);
INSERT INTO om.order_details VALUES (802,3,1);
INSERT INTO om.order_details VALUES (824,7,2);
INSERT INTO om.order_details VALUES (829,1,1);
INSERT INTO om.order_details VALUES (550,4,1);
INSERT INTO om.order_details VALUES (796,7,1);
INSERT INTO om.order_details VALUES (829,2,1);
INSERT INTO om.order_details VALUES (693,6,1);
INSERT INTO om.order_details VALUES (29,3,1);
INSERT INTO om.order_details VALUES (32,7,1);
INSERT INTO om.order_details VALUES (242,1,1);
INSERT INTO om.order_details VALUES (298,1,1);
INSERT INTO om.order_details VALUES (479,4,1);
INSERT INTO om.order_details VALUES (548,9,1);
INSERT INTO om.order_details VALUES (627,9,1);
INSERT INTO om.order_details VALUES (778,3,1);
INSERT INTO om.order_details VALUES (687,8,1);
INSERT INTO om.order_details VALUES (19,5,1);
INSERT INTO om.order_details VALUES (89,4,1);
INSERT INTO om.order_details VALUES (242,6,1);
INSERT INTO om.order_details VALUES (264,4,1);
INSERT INTO om.order_details VALUES (550,1,1);
INSERT INTO om.order_details VALUES (631,10,1);
INSERT INTO om.order_details VALUES (693,7,3);
INSERT INTO om.order_details VALUES (824,3,1);
INSERT INTO om.order_details VALUES (829,5,1);
INSERT INTO om.order_details VALUES (829,9,1);
