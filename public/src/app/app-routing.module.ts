import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./modules/pages/home/home.component";
import { UserProfileComponent } from "./modules/pages/user-profile/user-profile.component"

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {path: 'userProfile', component: UserProfileComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
