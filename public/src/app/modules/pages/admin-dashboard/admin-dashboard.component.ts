import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.scss']
})
export class AdminDashboardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  createAdmin(): void{
    window.location.href="http://localhost:4200/register-center-admin"
  }
  createCenter(): void{
    window.location.href="http://localhost:4200/register-center"
  }
}
