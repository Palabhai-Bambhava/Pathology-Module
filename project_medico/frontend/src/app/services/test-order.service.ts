import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TestOrder } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class TestOrderService {
  private apiUrl = 'http://localhost:8080/api/orders';

  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<TestOrder[]> {
    return this.http.get<TestOrder[]>(this.apiUrl);
  }

  getTodayOrders(): Observable<TestOrder[]> {
    return this.http.get<TestOrder[]>(`${this.apiUrl}/today`);
  }

  getOrderById(id: number): Observable<TestOrder> {
    return this.http.get<TestOrder>(`${this.apiUrl}/${id}`);
  }

  createOrder(order: TestOrder): Observable<TestOrder> {
    return this.http.post<TestOrder>(this.apiUrl, order);
  }

  updateOrderStatus(id: number, status: string): Observable<TestOrder> {
    return this.http.put<TestOrder>(`${this.apiUrl}/${id}/status`, { status });
  }
}