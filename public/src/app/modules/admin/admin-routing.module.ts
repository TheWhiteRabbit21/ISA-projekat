import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';
import { RegisteredUsersListComponent } from './pages/registered-users-list/registered-users-list.component';
import { RegisterCenterAdminComponent } from './pages/register-center-admin/register-center-admin.component';
import { RegisterCenterComponent } from './pages/register-center/register-center.component';

const routes: Routes = [
  {
    path: '',
    component: AdminComponent,
    children: [
      {
        path: 'registered-users',
        component: RegisteredUsersListComponent,
      },
      {
        path: 'register-center',
        component: RegisterCenterComponent,
      },
      {
        path: 'register-center-admin',
        component: RegisterCenterAdminComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
