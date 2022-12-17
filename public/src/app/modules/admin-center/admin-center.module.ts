import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminCenterRoutingModule } from './admin-center-routing.module';
import { AdminCenterComponent } from './admin-center.component';
import { AdminCenterNavComponent } from './pages/nav/admin-center-nav.component';
import { RegisteredUsersListComponent } from './pages/registered-users-list/registered-users-list.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/material/material.module";
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    AdminCenterComponent,
    AdminCenterNavComponent,
    RegisteredUsersListComponent
  ],
  imports: [
    CommonModule,
    AdminCenterRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    MatListModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTableModule,
    FormsModule
  ]
})
export class AdminCenterModule { }
