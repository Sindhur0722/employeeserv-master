DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
  employee_id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  DOB DATE DEFAULT NULL,
  address VARCHAR(250) DEFAULT NULL
);

CREATE TABLE address (
    address_id INT NOT NULL PRIMARY KEY,
    line1 VARCHAR(255) NOT NULL,
    line2 VARCHAR(255),
    city VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    zip_code INT NOT NULL,
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);