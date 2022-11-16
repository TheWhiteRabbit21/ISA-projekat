import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { MaterialModule } from 'src/app/material/material.module';
import { RegisterComponent } from './welcome/register/register.component';
import { BloodBanksListComponent } from './blood-banks-list/blood-banks-list.component';
import { RegisterCenterComponent } from './register-center/register-center.component';
import { FormsModule } from '@angular/forms';
import { RegisterCenterAdminComponent } from './register-center-admin/register-center-admin.component';

@NgModule({
  declarations: [
    HomeComponent,
    WelcomeComponent,
    RegisterComponent,
    BloodBanksListComponent,
    RegisterCenterComponent,
    RegisterCenterAdminComponent
  ],
  imports: [
    FormsModule,
    CommonModule,
    AppRoutingModule,
    MaterialModule
  ]
})
export class PagesModule { }
