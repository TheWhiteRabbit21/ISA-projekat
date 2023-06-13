import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserComponent } from './user.component';
import { ReserveAppointmentComponent } from './pages/reserve-appointment/reserve-appointment.component';
import { ReservePredefinedAppointmentComponent } from './pages/reserve-predefined-appointment/reserve-predefined-appointment.component';
import { UserProfileComponent } from '../pages/user-profile/user-profile.component';
import { BloodDonorFormComponent } from '../pages/blood-donor-form/blood-donor-form.component';
import { ReservedAppointmentsComponent } from './pages/reserved-appointments/reserved-appointments.component';

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
      },
      {
        path: 'user-profile',
        component: UserProfileComponent,
      },
      {
        path: 'blood-donor-form',
        component: BloodDonorFormComponent,
      },
      {
        path: 'reserved-appointments',
        component: ReservedAppointmentsComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
