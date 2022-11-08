import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    HomeComponent,
    UserProfileComponent,
  ],
  imports: [
    CommonModule,
    AppRoutingModule,
  ]
})
export class PagesModule { }
