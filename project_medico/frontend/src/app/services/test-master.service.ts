import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { TestMaster } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class TestMasterService {
  private tests: TestMaster[] = [
    { id: 1, testName: 'Blood Test', testCode: 'BT001', sampleType: 'Blood', normalRange: '10-20', price: 100 },
    { id: 2, testName: 'Urine Test', testCode: 'UT001', sampleType: 'Urine', normalRange: '5-15', price: 50 }
  ];

  constructor(private http: HttpClient) { }

  getAllTests(): Observable<TestMaster[]> {
    return of(this.tests);
  }

  createTest(test: TestMaster): Observable<TestMaster> {
    test.id = this.tests.length + 1;
    this.tests.push(test);
    return of(test);
  }

  searchTests(name: string): Observable<TestMaster[]> {
    const filtered = this.tests.filter(test => 
      test.testName.toLowerCase().includes(name.toLowerCase())
    );
    return of(filtered);
  }
}