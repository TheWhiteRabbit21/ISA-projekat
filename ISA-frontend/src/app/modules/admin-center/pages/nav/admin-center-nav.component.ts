import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs';
import { AuthService } from 'src/app/modules/pages/login/log-auth.service';
import { UserDataService } from 'src/app/modules/pages/login/log-user-data.service';

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

  id: number = 0; //kad bude login namestiti da ne bude hardkodovano

  m_Routes: NavRoute[] = [
    {
      path: 'registered-users',
      title: 'Registered Users'
    },
    {
      path: 'work-calendar',
      title: 'Work Calendar'
    },
    {
      path: 'define-appointment',
      title: 'Define Appointment'
    }
  ];
  constructor(private m_UserDataService : UserDataService) { 
  }

  ngOnInit(): void {
    
    this.m_UserDataService.m_UserData$.pipe(tap(user_data => {
      if(user_data != null) this.id = user_data?.id;
      this.m_Routes.push(    {
        path: 'admincenterprofile/' + this.id,
        title: 'Admin center profile'
      });
    })).subscribe();
  }
}
