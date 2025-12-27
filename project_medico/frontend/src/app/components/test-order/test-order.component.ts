import { Component, OnInit } from '@angular/core';
import { TestOrder, TestMaster } from '../../models/models';
import { TestOrderService } from '../../services/test-order.service';
import { TestMasterService } from '../../services/test-master.service';

@Component({
  selector: 'app-test-order',
  templateUrl: './test-order.component.html',
  styleUrls: ['./test-order.component.css']
})
export class TestOrderComponent implements OnInit {
  orders: TestOrder[] = [];
  todayOrders: TestOrder[] = [];
  availableTests: TestMaster[] = [];
  showForm: boolean = false;
  
  newOrder: TestOrder = {
    patientName: '',
    phone: '',
    test: {} as TestMaster
  };

  constructor(
    private testOrderService: TestOrderService,
    private testMasterService: TestMasterService
  ) { }

  ngOnInit(): void {
    this.loadTodayOrders();
    this.loadAvailableTests();
  }

  loadTodayOrders(): void {
    this.testOrderService.getTodayOrders().subscribe(
      data => this.todayOrders = data
    );
  }

  loadAvailableTests(): void {
    this.testMasterService.getAllTests().subscribe(
      data => this.availableTests = data
    );
  }

  createOrder(): void {
    this.testOrderService.createOrder(this.newOrder).subscribe(
      data => {
        this.loadTodayOrders();
        this.resetForm();
        alert('Order created successfully!');
      },
      error => alert('Error creating order')
    );
  }

  resetForm(): void {
    this.newOrder = {
      patientName: '',
      phone: '',
      test: {} as TestMaster
    };
    this.showForm = false;
  }

  toggleForm(): void {
    this.showForm = !this.showForm;
    if (!this.showForm) {
      this.resetForm();
    }
  }

  onTestSelect(event: any): void {
    const testId = parseInt(event.target.value);
    const selectedTest = this.availableTests.find(test => test.id === testId);
    if (selectedTest) {
      this.newOrder.test = selectedTest;
    }
  }
}