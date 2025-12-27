import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <div>
      <h1>Pathology Lab Management</h1>
      <app-test-master></app-test-master>
    </div>
  `,
  styles: [`
    div {
      padding: 20px;
      font-family: Arial, sans-serif;
    }
    h1 {
      color: #333;
      text-align: center;
    }
  `]
})
export class AppComponent {
  title = 'Pathology Lab';
}