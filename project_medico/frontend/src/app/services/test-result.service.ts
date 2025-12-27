import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TestResult } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class TestResultService {
  private apiUrl = 'http://localhost:8080/api/results';

  constructor(private http: HttpClient) { }

  createResult(result: TestResult): Observable<TestResult> {
    return this.http.post<TestResult>(this.apiUrl, result);
  }

  getResultByOrderId(orderId: number): Observable<TestResult> {
    return this.http.get<TestResult>(`${this.apiUrl}/order/${orderId}`);
  }
}