import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HomeComponent } from "./modules/pages/home/home.component";
import { RegisterCenterComponent } from "./modules/pages/register-center/register-center.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'register-center', component: RegisterCenterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
