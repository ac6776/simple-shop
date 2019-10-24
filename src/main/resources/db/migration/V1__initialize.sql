SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS products;

CREATE TABLE products (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  title                 VARCHAR(50) NOT NULL,
  cost                  DECIMAL(8,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO products (title, cost)
VALUES
('TV', 30.99),
('Smartphone', 749.99),
('Bicycle', 2499.99),
('Camera', 349.49),
('Game Console', 250.0),
('Guitar', 1499.49),
('Helmet', 999.99),
('Sunglasses', 145.0),
('Hummer', 9.99);