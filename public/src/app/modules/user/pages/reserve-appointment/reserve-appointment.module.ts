import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule, FormsModule } from "@angular/forms";
import { MatListModule } from "@angular/material/list";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatTableModule } from "@angular/material/table";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MaterialModule } from "src/app/material/material.module";
import { ReserveAppointmentComponent } from "./reserve-appointment.component";

@NgModule({
  declarations: [
   ReserveAppointmentComponent
  ],
  imports: [
    NgModule,
    CommonModule,
    ReactiveFormsModule,
    MatListModule,
    MatSidenavModule,
    MatTableModule,
    MatToolbarModule,
    MaterialModule
  ]
})
export class ReserveAppointmentModule { }
