# Pathology Lab Management System

A demo-ready pathology lab management mini-module built with Spring Boot and Angular.

## Features

1. **Test Master Management**
   - Create/List pathology tests
   - Search tests by name
   - Manage test details (name, code, sample type, normal range, price)

2. **Test Order Management**
   - Create test orders for patients
   - Auto-generate unique order numbers
   - List today's orders
   - Track order status (PENDING/COMPLETED)

3. **Result Entry**
   - Enter test results and technician notes
   - Mark orders as completed
   - View completed results

## Tech Stack

- **Backend**: Spring Boot, Spring Data JPA, MySQL
- **Frontend**: Angular
- **Database**: MySQL

## Quick Start

### Backend Setup
1. Navigate to `backend` directory
2. Update `application.properties` with your MySQL credentials
3. Run: `mvn spring-boot:run`
4. Backend runs on: http://localhost:8080

### Frontend Setup
1. Navigate to `frontend` directory
2. Run: `npm install`
3. Run: `ng serve`
4. Frontend runs on: http://localhost:4200

### Database Setup
```sql
CREATE DATABASE pathology_lab;
```

## API Endpoints

### Test Master
- GET `/api/tests` - List all tests
- POST `/api/tests` - Create test
- GET `/api/tests/search?name={name}` - Search tests

### Test Orders
- GET `/api/orders` - List all orders
- POST `/api/orders` - Create order
- GET `/api/orders/today` - Today's orders
- PUT `/api/orders/{id}/status` - Update status

### Results
- POST `/api/results` - Enter result
- GET `/api/results/order/{orderId}` - Get results by order

## Project Structure
```
project_medico/
├── backend/          # Spring Boot application
├── frontend/         # Angular application
└── README.md
```