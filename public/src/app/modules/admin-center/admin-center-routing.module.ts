import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminCenterComponent } from './admin-center.component';
import { AdminCenterProfileComponent } from './pages/admin-center-profile/admin-center-profile.component';
import { RegisteredUsersListComponent } from './pages/registered-users-list/registered-users-list.component';

const routes: Routes = [
  {
    path: '',
    component: AdminCenterComponent,
    children: [
      {
        path: 'registered-users',
        component: RegisteredUsersListComponent,
      },
      {
        path: 'admincenterprofile/:id',
        component: AdminCenterProfileComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminCenterRoutingModule { }
