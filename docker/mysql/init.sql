CREATE DATABASE IF NOT EXISTS example;
CREATE DATABASE IF NOT EXISTS example_test;

USE example;
DROP TABLE IF EXISTS member;

CREATE TABLE member
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(1000),
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  PRIMARY KEY (id)
) ENGINE = 'InnoDB', DEFAULT CHARSET=utf8mb4, ROW_FORMAT=DYNAMIC;

insert into member values (1, 'Alice', '', current_timestamp, current_timestamp);
insert into member values (2, 'Bob',  '', current_timestamp, current_timestamp);

USE example_test;
DROP TABLE IF EXISTS member;

CREATE TABLE member
(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(1000),
  created_at DATETIME NOT NULL,
  updated_at DATETIME NOT NULL,
  PRIMARY KEY (id)
) ENGINE = 'InnoDB', DEFAULT CHARSET=utf8mb4, ROW_FORMAT=DYNAMIC;
