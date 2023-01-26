import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../pages/login/log-auth.service';

@Component({
  selector: 'app-admin-center',
  templateUrl: './admin-center.component.html',
  styleUrls: ['./admin-center.component.scss']
})
export class AdminCenterComponent implements OnInit {

  constructor(private m_Router : Router, private m_AuthService : AuthService) { }

  ngOnInit(): void {
  }

  logout(): void {
    this.m_AuthService.logout();
    this.m_Router.navigate(['/login']);
  }

}
