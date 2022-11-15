import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { HomeComponent } from './home/home.component';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { AdminCenterProfileComponent } from './admin-center-profile/admin-center-profile.component';

@NgModule({
  declarations: [
    HomeComponent,
    AdminProfileComponent,
    AdminCenterProfileComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
  ]
})
export class PagesModule { }
