import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { HomeComponent } from './home/home.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { MaterialModule } from 'src/app/material/material.module';
import { RegisterComponent } from './welcome/register/register.component';
import { BloodBanksListComponent } from './blood-banks-list/blood-banks-list.component';

@NgModule({
  declarations: [
    HomeComponent,
    WelcomeComponent,
    RegisterComponent,
    BloodBanksListComponent
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
    MaterialModule
  ]
})
export class PagesModule { }
