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
import { RegisterComponent } from './welcome/register/register.component';
import { BloodBanksListComponent } from './blood-banks-list/blood-banks-list.component';
import { RegisterCenterComponent } from './register-center/register-center.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeComponent,
    UserProfileComponent,
    AdminProfileComponent,
    AdminCenterProfileComponent,
    WelcomeComponent,
    RegisterComponent,
    BloodBanksListComponent,
    RegisterCenterComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    AppRoutingModule,
    FormsModule,
    MatTableModule,
    MaterialModule

  ]
})
export class PagesModule { }
