--liquibase formatted sql
--changeset jeeva:2

INSERT INTO employees (first_name, last_name, email, company, department, salary)
VALUES
('John', 'Doe', 'john@example.com', 'Acheron', 'IT', 60000),
('Jane', 'Smith', 'jane@example.com', 'Acheron', 'HR', 55000);
