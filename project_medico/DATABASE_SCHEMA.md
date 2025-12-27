# Database Schema

## Database Setup

```sql
CREATE DATABASE pathology_lab;
USE pathology_lab;
```

## Tables

### 1. test_master
Stores pathology test definitions.

```sql
CREATE TABLE test_master (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    test_name VARCHAR(255) NOT NULL UNIQUE,
    test_code VARCHAR(100) NOT NULL UNIQUE,
    sample_type VARCHAR(100) NOT NULL,
    normal_range VARCHAR(255),
    price DECIMAL(10,2) NOT NULL
);
```

### 2. test_order
Stores patient test orders.

```sql
CREATE TABLE test_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    test_id BIGINT NOT NULL,
    order_number VARCHAR(50) UNIQUE NOT NULL,
    order_date DATE NOT NULL,
    status ENUM('PENDING', 'COMPLETED') DEFAULT 'PENDING',
    FOREIGN KEY (test_id) REFERENCES test_master(id)
);
```

### 3. test_result
Stores test results for completed orders.

```sql
CREATE TABLE test_result (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT NOT NULL UNIQUE,
    test_result_value VARCHAR(500) NOT NULL,
    technician_notes TEXT,
    result_date DATETIME NOT NULL,
    FOREIGN KEY (order_id) REFERENCES test_order(id)
);
```

## Sample Data

### Test Master Data
```sql
INSERT INTO test_master (test_name, test_code, sample_type, normal_range, price) VALUES
('Complete Blood Count', 'CBC', 'Blood', '4.5-11.0 x10³/µL', 25.00),
('Blood Sugar Fasting', 'BSF', 'Blood', '70-100 mg/dL', 15.00),
('Lipid Profile', 'LIPID', 'Blood', 'Total Cholesterol < 200 mg/dL', 35.00),
('Urine Routine', 'URINE', 'Urine', 'Normal', 20.00),
('Thyroid Function Test', 'TFT', 'Blood', 'TSH: 0.4-4.0 mIU/L', 45.00);
```

## Entity Relationships

- **test_order** has a many-to-one relationship with **test_master**
- **test_result** has a one-to-one relationship with **test_order**
- Each order can have only one result
- Each test master can be used in multiple orders

## Indexes

The application automatically creates indexes on:
- Primary keys (id columns)
- Foreign keys (test_id, order_id)
- Unique constraints (test_code, order_number)

## Auto-generated Fields

- **order_number**: Generated in format YYYYMMDDXXX (date + sequence)
- **order_date**: Defaults to current date
- **result_date**: Defaults to current timestamp
- **status**: Defaults to 'PENDING'