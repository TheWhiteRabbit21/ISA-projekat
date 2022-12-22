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

  id: number = 4; //kad bude login namestiti da ne bude hardkodovano

  m_Routes: NavRoute[] = [
    {
      path: 'registered-users',
      title: 'Registered Users'
    },
    {
      path: 'admincenterprofile/' + this.id,
      title: 'Admin center profile'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
