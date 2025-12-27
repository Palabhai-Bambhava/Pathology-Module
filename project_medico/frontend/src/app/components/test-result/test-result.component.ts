import { Component, OnInit } from '@angular/core';
import { TestResult, TestOrder } from '../../models/models';
import { TestResultService } from '../../services/test-result.service';
import { TestOrderService } from '../../services/test-order.service';

@Component({
  selector: 'app-test-result',
  templateUrl: './test-result.component.html',
  styleUrls: ['./test-result.component.css']
})
export class TestResultComponent implements OnInit {
  pendingOrders: TestOrder[] = [];
  selectedOrder: TestOrder | null = null;
  existingResult: TestResult | null = null;
  
  newResult: TestResult = {
    testOrder: {} as TestOrder,
    testResultValue: '',
    technicianNotes: ''
  };

  constructor(
    private testResultService: TestResultService,
    private testOrderService: TestOrderService
  ) { }

  ngOnInit(): void {
    this.loadPendingOrders();
  }

  loadPendingOrders(): void {
    this.testOrderService.getAllOrders().subscribe(
      data => {
        this.pendingOrders = data.filter(order => order.status === 'PENDING');
      }
    );
  }

  selectOrder(order: TestOrder): void {
    this.selectedOrder = order;
    this.newResult.testOrder = order;
    
    // Check if result already exists
    if (order.id) {
      this.testResultService.getResultByOrderId(order.id).subscribe(
        result => {
          this.existingResult = result;
          this.newResult.testResultValue = result.testResultValue;
          this.newResult.technicianNotes = result.technicianNotes || '';
        },
        error => {
          this.existingResult = null;
        }
      );
    }
  }

  submitResult(): void {
    if (!this.selectedOrder || this.existingResult) {
      return;
    }

    this.testResultService.createResult(this.newResult).subscribe(
      data => {
        alert('Result submitted successfully!');
        this.loadPendingOrders();
        this.resetForm();
      },
      error => alert('Error submitting result')
    );
  }

  resetForm(): void {
    this.selectedOrder = null;
    this.existingResult = null;
    this.newResult = {
      testOrder: {} as TestOrder,
      testResultValue: '',
      technicianNotes: ''
    };
  }
}