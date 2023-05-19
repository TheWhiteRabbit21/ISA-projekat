import { Component, OnInit } from '@angular/core';
import { ReserveAppointmentComponent } from '../reserve-appointment/reserve-appointment.component';

export interface NavRoute {
  path: string;
  title: string;
}

@Component({
  selector: 'app-user-nav',
  templateUrl: './user-nav.component.html',
  styleUrls: ['./user-nav.component.scss']
})
export class UserNavComponent implements OnInit {
  m_Routes: NavRoute[] = [
    {
      path: 'reserve-appointment',
      title: 'Reserve Appointment'
    }
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
