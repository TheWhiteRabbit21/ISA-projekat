import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdminProfileComponent } from "./modules/pages/admin-profile/admin-profile.component";
import { HomeComponent } from "./modules/pages/home/home.component";
import { UserProfileComponent } from "./modules/pages/user-profile/user-profile.component"
import { WelcomeComponent } from "./modules/pages/welcome/welcome.component";
import { BloodBanksListComponent } from "./modules/pages/blood-banks-list/blood-banks-list.component";
import { BloodDonorFormComponent } from "./modules/pages/blood-donor-form/blood-donor-form.component";
import { RegisterComponent } from "./modules/pages/register/register.component";
import { LoginComponent } from "./modules/pages/login/login.component";
import { BloodDonorsListComponent } from "./modules/pages/blood-donors-list/blood-donors-list.component";
import { AdminAppointmentComponent } from "./modules/admin-center/pages/admin-appointment/admin-appointment.component";
import { StartAppointmentComponent } from "./modules/admin-center/pages/start-appointment/start-appointment.component";

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () => import('./modules/admin/admin.module').then(a => a.AdminModule)
  },
  {
    path: 'admin-center',
    loadChildren: () => import('./modules/admin-center/admin-center.module').then(ac => ac.AdminCenterModule)
  },
  {
    path: 'user',
    loadChildren: () => import('./modules/user/user.module').then(ac => ac.UserModule)
  },
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: 'centers', component: BloodBanksListComponent},
  { path: 'welcome', component: WelcomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'userProfile', component: UserProfileComponent},
  { path: 'adminprofile/:id', component: AdminProfileComponent },
  { path: 'blood-donor-form', component: BloodDonorFormComponent},
  { path: 'blood-donors-list', component: BloodDonorsListComponent},
  { path: 'admin-appointment/:id', component: AdminAppointmentComponent},
  { path: 'start-appointment/:id', component: StartAppointmentComponent},
  { path: '**', redirectTo: 'welcome', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
