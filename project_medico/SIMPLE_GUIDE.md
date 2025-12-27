# Simple Pathology Lab System

## What This Does
- Manage pathology tests (add, view, search)
- Simple Angular frontend with mock data
- No backend needed for basic demo

## Quick Start

### Frontend Only (No Backend)
1. Open terminal in `frontend` folder
2. Run: `npm install`
3. Run: `ng serve`
4. Open: http://localhost:4200

## Features
- **Add Tests**: Click "Add Test" button
- **View Tests**: See all tests in table
- **Search Tests**: Type name and click search

## Sample Data
The app starts with 2 sample tests:
- Blood Test (BT001) - $100
- Urine Test (UT001) - $50

## Code Structure
```
frontend/
├── src/app/
│   ├── components/test-master/    # Main component
│   ├── services/test-master.service.ts  # Mock data service
│   ├── models/models.ts           # Data types
│   └── app.module.ts             # App setup
```

## Key Files to Understand

### 1. TestMaster Model (models.ts)
```typescript
export interface TestMaster {
  id?: number;
  testName: string;
  testCode: string;
  sampleType: string;
  normalRange: string;
  price: number;
}
```

### 2. Service (test-master.service.ts)
- Uses mock data instead of HTTP calls
- Has sample tests built-in
- Methods: getAllTests(), createTest(), searchTests()

### 3. Component (test-master.component.ts)
- Manages form data and test list
- Handles user interactions
- Simple methods: loadTests(), createTest(), searchTests()

## How It Works
1. **Service** provides mock data
2. **Component** gets data from service
3. **Template** shows data in tables and forms
4. **User** can add new tests via form
5. **Search** filters existing tests

## No Backend Needed
- All data stored in memory
- Resets when page refreshes
- Perfect for learning Angular basics

## Next Steps
To add backend:
1. Replace mock service with HTTP calls
2. Set up Spring Boot backend
3. Connect to MySQL database