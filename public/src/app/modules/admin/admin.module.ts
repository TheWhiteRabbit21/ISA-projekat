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
import { RegisterAdminComponent } from './pages/register-admin/register-admin.component';
import { MatOptionModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatDialogModule } from '@angular/material/dialog';
import { ChangePasswordDialog } from './admin.component';
import { ComplaintsComponent } from './pages/complaints/complaints.component';
import { AnswerDialog } from './pages/complaints/complaints.component';

@NgModule({
  declarations: [
    AdminComponent,
    RegisteredUsersListComponent,
    RegisterCenterAdminComponent,
    RegisterCenterComponent,
    AdminNavComponent,
    AnswerDialog,
    ChangePasswordDialog,
    RegisterAdminComponent,
    ComplaintsComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    MatListModule,
    MatDialogModule,
    MatOptionModule,
    MatSelectModule,
    MatToolbarModule,
    MatSidenavModule,
    MatTableModule,
    FormsModule
  ]
})
export class AdminModule { }
