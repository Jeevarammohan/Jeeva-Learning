--liquibase formatted sql
--changeset jeeva:1

CREATE TABLE employees (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    company VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
