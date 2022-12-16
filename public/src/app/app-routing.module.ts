import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdminCenterProfileComponent } from "./modules/pages/admin-center-profile/admin-center-profile.component";
import { AdminProfileComponent } from "./modules/pages/admin-profile/admin-profile.component";
import { HomeComponent } from "./modules/pages/home/home.component";
import { UserProfileComponent } from "./modules/pages/user-profile/user-profile.component"
import { RegisterCenterComponent } from "./modules/pages/register-center/register-center.component";
import { WelcomeComponent } from "./modules/pages/welcome/welcome.component";
import { RegisterCenterAdminComponent } from "./modules/pages/register-center-admin/register-center-admin.component";
import { BloodBankListService } from "./modules/pages/blood-banks-list/blood-bank-list.service";
import { BloodBanksListComponent } from "./modules/pages/blood-banks-list/blood-banks-list.component";
import { BloodDonorFormComponent } from "./modules/pages/blood-donor-form/blood-donor-form.component";
import { RegisteredUsersListComponent } from "./modules/pages/registered-users-list/registered-users-list.component";
import { AdminDashboardComponent } from "./modules/pages/admin-dashboard/admin-dashboard.component";
import { AdminAppointmentComponent } from "./modules/pages/admin-appointment/admin-appointment.component"


const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  {path: 'centers', component: BloodBanksListComponent},
  { path: 'welcome', component: WelcomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'register-center', component: RegisterCenterComponent },
  { path: 'register-center-admin', component: RegisterCenterAdminComponent },
  { path: 'registered-users', component: RegisteredUsersListComponent },
  { path: 'userProfile', component: UserProfileComponent},
  { path: 'admin-dashboard', component: AdminDashboardComponent},
  { path: 'adminprofile/:id', component: AdminProfileComponent },
  { path: 'admincenterprofile/:id', component: AdminCenterProfileComponent },
  {path: 'blood-donor-form', component: BloodDonorFormComponent},
  { path: '**', redirectTo: 'welcome', pathMatch: 'full' },
  {path: 'adminAppointment', component: AdminAppointmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
