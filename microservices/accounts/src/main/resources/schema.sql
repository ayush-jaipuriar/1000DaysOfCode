-- Customers Table
CREATE TABLE IF NOT EXISTS customers (
  customer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  mobile_number VARCHAR(255),
  created_at TIMESTAMP,
  created_by VARCHAR(255),
  updated_at TIMESTAMP,
  updated_by VARCHAR(255)
);

-- Accounts Table
CREATE TABLE IF NOT EXISTS accounts (
  account_number BIGINT PRIMARY KEY,
  customer_id BIGINT,
  account_type VARCHAR(255),
  branch_address VARCHAR(255),
  created_at TIMESTAMP,
  created_by VARCHAR(255),
  updated_at TIMESTAMP,
  updated_by VARCHAR(255),
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
