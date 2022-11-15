import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { AdminCenterProfileComponent } from "./modules/pages/admin-center-profile/admin-center-profile.component";
import { AdminProfileComponent } from "./modules/pages/admin-profile/admin-profile.component";
import { HomeComponent } from "./modules/pages/home/home.component";

const routes: Routes = [
  { path: '', redirectTo: 'welcome', pathMatch: 'full' },
  //{ path: 'welcome', component: WelcomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'adminprofile', component: AdminProfileComponent },
  { path: 'admincenterprofile/:id', component: AdminCenterProfileComponent },
  { path: '**', redirectTo: 'welcome', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
