# Pathology Lab Management System - Setup & Usage Guide

## Prerequisites

- Java 17 or higher
- Node.js 16 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher
- Angular CLI 17 or higher

## Database Setup

1. **Install MySQL** and create database:
```sql
CREATE DATABASE pathology_lab;
```

2. **Update database credentials** in `backend/src/main/resources/application.properties`:
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

## Backend Setup (Spring Boot)

1. **Navigate to backend directory**:
```bash
cd backend
```

2. **Install dependencies and run**:
```bash
mvn clean install
mvn spring-boot:run
```

3. **Verify backend** is running at: http://localhost:8080

## Frontend Setup (Angular)

1. **Navigate to frontend directory**:
```bash
cd frontend
```

2. **Install dependencies**:
```bash
npm install
```

3. **Install Angular CLI globally** (if not installed):
```bash
npm install -g @angular/cli@17
```

4. **Run the application**:
```bash
ng serve
```

5. **Access the application** at: http://localhost:4200

## Application Flow & Usage

### 1. Test Master Management
**Purpose**: Set up pathology tests that can be ordered

**Steps**:
1. Click "Test Master" tab
2. Click "Add New Test" button
3. Fill in test details:
   - Test Name (e.g., "Complete Blood Count")
   - Test Code (e.g., "CBC")
   - Sample Type (e.g., "Blood")
   - Normal Range (e.g., "4.5-11.0 x10³/µL")
   - Price (e.g., 25.00)
4. Click "Create Test"

**Features**:
- View all available tests
- Search tests by name
- Unique test codes enforced

### 2. Test Order Management
**Purpose**: Create patient test orders

**Steps**:
1. Click "Test Orders" tab
2. Click "Create New Order" button
3. Fill in patient details:
   - Patient Name
   - Phone Number
   - Select Test from dropdown
4. Click "Create Order"

**Features**:
- Auto-generated order numbers (YYYYMMDDXXX format)
- View today's orders
- Order status tracking (PENDING/COMPLETED)

### 3. Result Entry
**Purpose**: Enter test results and complete orders

**Steps**:
1. Click "Result Entry" tab
2. View pending orders list
3. Click "Enter Result" for desired order
4. Fill in:
   - Test Result Value
   - Technician Notes (optional)
5. Click "Submit Result"

**Features**:
- Only pending orders shown
- Order automatically marked as COMPLETED
- View existing results for completed orders

## API Endpoints

### Test Master APIs
- `GET /api/tests` - Get all tests
- `POST /api/tests` - Create new test
- `GET /api/tests/search?name={name}` - Search tests
- `GET /api/tests/{id}` - Get test by ID

### Test Order APIs
- `GET /api/orders` - Get all orders
- `GET /api/orders/today` - Get today's orders
- `POST /api/orders` - Create new order
- `GET /api/orders/{id}` - Get order by ID
- `PUT /api/orders/{id}/status` - Update order status

### Test Result APIs
- `POST /api/results` - Create test result
- `GET /api/results/order/{orderId}` - Get result by order ID

## Sample Test Data

You can add these sample tests to get started:

1. **Complete Blood Count**
   - Code: CBC
   - Sample: Blood
   - Normal Range: 4.5-11.0 x10³/µL
   - Price: $25.00

2. **Blood Sugar Fasting**
   - Code: BSF
   - Sample: Blood
   - Normal Range: 70-100 mg/dL
   - Price: $15.00

3. **Lipid Profile**
   - Code: LIPID
   - Sample: Blood
   - Normal Range: Total Cholesterol < 200 mg/dL
   - Price: $35.00

## Technical Assessment Points

### Backend Architecture
- **Entities**: Clean JPA entities with proper relationships
- **Repositories**: Spring Data JPA with custom queries
- **Services**: Business logic separation
- **Controllers**: RESTful API design with proper HTTP methods
- **Validation**: Bean validation annotations

### Frontend Architecture
- **Components**: Modular Angular components
- **Services**: HTTP client services for API communication
- **Models**: TypeScript interfaces for type safety
- **Forms**: Template-driven forms with validation
- **Routing**: Tab-based navigation

### Key Features Demonstrated
- **CRUD Operations**: Complete Create, Read, Update operations
- **Search Functionality**: Dynamic search with backend filtering
- **Auto-generation**: Order number generation with date prefix
- **Status Management**: Order status workflow
- **Data Relationships**: Foreign key relationships between entities
- **Error Handling**: Basic error handling and user feedback

## Troubleshooting

### Common Issues

1. **Backend won't start**:
   - Check MySQL is running
   - Verify database credentials
   - Ensure port 8080 is available

2. **Frontend won't start**:
   - Run `npm install` to install dependencies
   - Check Node.js version (16+)
   - Ensure port 4200 is available

3. **CORS Issues**:
   - Backend includes CORS configuration for localhost:4200
   - Check browser console for CORS errors

4. **Database Connection**:
   - Verify MySQL service is running
   - Check database name and credentials
   - Ensure MySQL driver is included in dependencies

## Future Enhancements

If time permits, consider adding:
- PDF report generation
- Patient management
- Test result history
- Advanced search filters
- User authentication
- Audit logging