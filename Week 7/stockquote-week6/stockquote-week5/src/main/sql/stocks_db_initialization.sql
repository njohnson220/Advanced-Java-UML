/** create the stocks database */
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS symbol CASCADE;
SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE symbol(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  stock_symbol VARCHAR(6) NOT NULL
);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS person CASCADE;
SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE person(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS linkedStocks CASCADE;
SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE linkedStocks(
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  symbol_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (id) ON DELETE CASCADE,
  FOREIGN KEY (symbol_id) REFERENCES symbol (id) ON DELETE CASCADE
);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS quotes CASCADE;
SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE quotes(
   id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(6) NOT NULL,
   time DATETIME NOT NULL,
   price FLOAT(10,3) NOT NULL
);






INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-03 00:00:01','363.21');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-02 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-03 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-04 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-05 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-06 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-07 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-08 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AFL','2000-01-09 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-10 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-11 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-12 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AD','2000-01-13 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('TSLA','2000-01-14 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-15 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('QRS','2000-01-16 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-17 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMC','2000-01-18 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-19 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('TACT','2000-01-20 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOGL','2000-01-21 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-22 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('TSLA','2000-01-23 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-24 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-25 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-26 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AZZ','2000-01-27 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('ARW','2000-01-28 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOGL','2000-01-29 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-30 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-31 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOGL','2000-02-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-02 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-03 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-04 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-05 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-06 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-07 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('TSLA','2000-02-08 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-09 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-10 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-02-11 00:00:01','118.27');

INSERT INTO person (first_name, last_name, birth_date) VALUES ('John','Smith','1967-07-04 00:00:01');
INSERT INTO person (first_name, last_name, birth_date) VALUES ('Nathan','Johnson','1999-01-14 00:00:01');
INSERT INTO person (first_name, last_name, birth_date) VALUES ('Abraham','Lincoln','1809-01-12 00:00:01');
INSERT INTO person (first_name, last_name, birth_date) VALUES ('John','Kennedy','1917-05-29 00:00:01');


INSERT INTO symbol (stock_symbol) VALUE ('APPL');
INSERT INTO symbol (stock_symbol) VALUE ('TSLA');
INSERT INTO symbol (stock_symbol) VALUE ('GOOGL');
INSERT INTO symbol (stock_symbol) VALUE ('ORCL');

INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (3, 1, 1);
INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (4, 2, 1);
INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (5, 3, 2);
INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (6, 2, 2);
INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (7, 3, 3);
INSERT INTO linkedStocks (id, symbol_id, person_id) VALUES (8, 1, 3);