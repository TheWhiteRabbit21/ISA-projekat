import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { RegisteredUsersListComponent } from './pages/registered-users-list/registered-users-list.component';
import { RegisterCenterAdminComponent } from './pages/register-center-admin/register-center-admin.component';
import { RegisterCenterComponent } from './pages/register-center/register-center.component';
import { AdminNavComponent } from './pages/nav/admin-nav.component';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MaterialModule } from "src/app/material/material.module";
import { MatListModule } from '@angular/material/list';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    AdminComponent,
    RegisteredUsersListComponent,
    RegisterCenterAdminComponent,
    RegisterCenterComponent,
    AdminNavComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    MatListModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTableModule,
    FormsModule
  ]
})
export class AdminModule { }
