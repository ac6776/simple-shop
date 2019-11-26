SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  username              VARCHAR(50) NOT NULL,
  password              CHAR(80) NOT NULL,
  first_name            VARCHAR(50) NOT NULL,
  last_name             VARCHAR(50) NOT NULL,
  email                 VARCHAR(50) NOT NULL,
  phone                 VARCHAR(15) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
  id                    INT(11) NOT NULL AUTO_INCREMENT,
  name                  VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users_roles;

CREATE TABLE users_roles (
  user_id               INT(11) NOT NULL,
  role_id               INT(11) NOT NULL,

  PRIMARY KEY (user_id,role_id),

--  KEY FK_ROLE_idx (role_id),

  CONSTRAINT FK_USER_ID_01 FOREIGN KEY (user_id)
  REFERENCES users (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION,

  CONSTRAINT FK_ROLE_ID FOREIGN KEY (role_id)
  REFERENCES roles (id)
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

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

INSERT INTO roles (name)
VALUES
('ROLE_EMPLOYEE'), ('ROLE_MANAGER'), ('ROLE_ADMIN');

INSERT INTO users (username,password,first_name,last_name,email,phone)
VALUES
('admin','$2y$12$IZtzRnCj51htrluqdzhk4.oHs4JKQZtHFMg28LdiGCT9.eQSQsF1q','Admin','Admin','admin@gmail.com','+79881111111');

INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(1, 2),
(1, 3);