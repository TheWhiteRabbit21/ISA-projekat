import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminCenterComponent } from './admin-center.component';
import { RegisteredUsersListComponent } from './pages/registered-users-list/registered-users-list.component';
import { WorkCalendarComponent } from './pages/work-calendar/work-calendar.component';

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
        path: 'work-calendar',
        component: WorkCalendarComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminCenterRoutingModule { }
