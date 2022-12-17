import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminCenterProfileComponent } from './admin-center-profile/admin-center-profile.component';
import { MatTableModule } from '@angular/material/table';
import { WelcomeComponent } from './welcome/welcome.component';
import { MaterialModule } from 'src/app/material/material.module';
import { RegisterComponent } from './register/register.component';
import { BloodBanksListComponent } from './blood-banks-list/blood-banks-list.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { BloodDonorFormComponent } from './blood-donor-form/blood-donor-form.component';
import { AdminAppointmentComponent } from './admin-appointment/admin-appointment.component';
import { LoginComponent } from './login/login.component';
import { BloodDonorsListComponent } from './blood-donors-list/blood-donors-list.component';
import { RegisteredUsersListComponent } from '../admin/pages/registered-users-list/registered-users-list.component';

@NgModule({
  declarations: [
    HomeComponent,
    UserProfileComponent,
    AdminProfileComponent,
    AdminCenterProfileComponent,
    WelcomeComponent,
    RegisterComponent,
    BloodBanksListComponent,
    BloodDonorFormComponent,
    AdminAppointmentComponent,
    LoginComponent,
    BloodDonorsListComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    MatTableModule,
    MaterialModule,
    ReactiveFormsModule
  ]
})
export class PagesModule { }
