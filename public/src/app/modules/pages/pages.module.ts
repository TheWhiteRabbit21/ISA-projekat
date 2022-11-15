import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from 'src/app/app-routing.module'; 
import { HomeComponent } from './home/home.component';
import { RegisterCenterComponent } from './register-center/register-center.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    HomeComponent,
    RegisterCenterComponent,
  ],
  imports: [
    FormsModule,
    CommonModule,
    AppRoutingModule,
  ]
})
export class PagesModule { }
