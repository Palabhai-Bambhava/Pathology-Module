import { Component } from '@angular/core';
import { TestMaster } from '../../models/models';
import { TestMasterService } from '../../services/test-master.service';

@Component({
  selector: 'app-test-master',
  templateUrl: './test-master.component.html',
  styleUrls: ['./test-master.component.css']
})
export class TestMasterComponent {
  tests: TestMaster[] = [];
  searchResults: TestMaster[] = [];
  searchTerm = '';
  showForm = false;
  
  newTest: TestMaster = {
    testName: '',
    testCode: '',
    sampleType: '',
    normalRange: '',
    price: 0
  };

  constructor(private testMasterService: TestMasterService) {
    this.loadTests();
  }

  loadTests() {
    this.testMasterService.getAllTests().subscribe(
      data => this.tests = data
    );
  }

  searchTests() {
    if (this.searchTerm.trim()) {
      this.testMasterService.searchTests(this.searchTerm).subscribe(
        data => this.searchResults = data
      );
    } else {
      this.searchResults = [];
    }
  }

  createTest() {
    this.testMasterService.createTest(this.newTest).subscribe(
      data => {
        this.loadTests();
        this.resetForm();
        alert('Test created!');
      }
    );
  }

  resetForm() {
    this.newTest = {
      testName: '',
      testCode: '',
      sampleType: '',
      normalRange: '',
      price: 0
    };
    this.showForm = false;
  }

  toggleForm() {
    this.showForm = !this.showForm;
    if (!this.showForm) {
      this.resetForm();
    }
  }
}