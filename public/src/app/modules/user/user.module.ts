import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { UserNavComponent } from './pages/nav/user-nav.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/material/material.module";
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';
import { ReserveAppointmentComponent } from './pages/reserve-appointment/reserve-appointment.component';


@NgModule({
  declarations: [
    UserComponent,
    UserNavComponent,
    ReserveAppointmentComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    MatListModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTableModule,
    FormsModule
  ]
})
export class UserModule { }
