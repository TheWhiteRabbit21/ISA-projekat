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
import { ReserveAppointmentComponent } from "./modules/user/pages/reserve-appointment/reserve-appointment.component";
import { AuthGuard } from "./modules/pages/login/log-auth.guard";
import { EmailVerifiedComponent } from "./modules/pages/email-verified/email-verified.component";
import { PredefinedAppointmentsCenterComponent } from "./modules/pages/predefined-appointments-center/predefined-appointments-center.component";

const routes: Routes = [
  {
    path: 'admin',
    loadChildren: () => import('./modules/admin/admin.module').then(a => a.AdminModule),
    canActivate : [AuthGuard],
    data: { expectedRoles: "ADMIN" }
  },
  {
    path: 'admin-center',
    loadChildren: () => import('./modules/admin-center/admin-center.module').then(ac => ac.AdminCenterModule),
    canActivate : [AuthGuard],
    data: { expectedRoles: "ADMIN_CENTER" }
  },
  {
    path: 'user',
    loadChildren: () => import('./modules/user/user.module').then(ac => ac.UserModule),
    canActivate : [AuthGuard],
    data: { expectedRoles: "USER" }
  },
  { path: 'predefined-appointments/:id', component: PredefinedAppointmentsCenterComponent},
  { path: 'centers', component: BloodBanksListComponent},
  { path: 'welcome', component: WelcomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'email-verified/:id', component: EmailVerifiedComponent },
  { path: 'login', component: LoginComponent },
  { path: 'userProfile', component: UserProfileComponent},
  { path: 'adminprofile/:id', component: AdminProfileComponent },
  { path: 'blood-donor-form', component: BloodDonorFormComponent},
  { path: 'blood-donors-list', component: BloodDonorsListComponent},
  { path: 'admin-appointment/:id', component: AdminAppointmentComponent},
  { path: 'start-appointment/:id', component: StartAppointmentComponent},
  { path: 'reserve-appointment', component: ReserveAppointmentComponent},
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  { path: '**', redirectTo: 'welcome', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
