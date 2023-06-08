import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { ReserveAppointmentComponent } from './pages/reserve-appointment/reserve-appointment.component';
import { ReservePredefinedAppointmentComponent } from './pages/reserve-predefined-appointment/reserve-predefined-appointment.component';

const routes: Routes = [
  {
    path: '',
    component: UserComponent,
    children: [
      {
        path: 'reserve-appointment',
        component: ReserveAppointmentComponent,
      },
      {
        path: 'reserve-predefined-appointment',
        component: ReservePredefinedAppointmentComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
