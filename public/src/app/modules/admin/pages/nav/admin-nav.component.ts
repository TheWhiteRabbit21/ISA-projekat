import { Component, OnInit } from '@angular/core';

export interface NavRoute {
  path: string;
  title: string;
}

@Component({
  selector: 'app-admin-nav',
  templateUrl: './admin-nav.component.html',
  styleUrls: ['./admin-nav.component.scss']
})
export class AdminNavComponent implements OnInit {
  m_Routes: NavRoute[] = [
    {
      path: 'registered-users',
      title: 'Registered Users'
    },
    {
      path: 'register-center',
      title: 'Register Center'
    },
    {
      path: 'register-center-admin',
      title: 'Register Center Admin'
    },
    {
      path: 'register-admin',
      title: 'Register Admin'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
