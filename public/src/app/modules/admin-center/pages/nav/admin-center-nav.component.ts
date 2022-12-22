import { Component, OnInit } from '@angular/core';

export interface NavRoute {
  path: string;
  title: string;
}

@Component({
  selector: 'app-admin-center-nav',
  templateUrl: './admin-center-nav.component.html',
  styleUrls: ['./admin-center-nav.component.scss']
})
export class AdminCenterNavComponent implements OnInit {
  m_Routes: NavRoute[] = [
    {
      path: 'registered-users',
      title: 'Registered Users'
    },
    {
      path: 'work-calendar',
      title: 'Work Calendar'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
