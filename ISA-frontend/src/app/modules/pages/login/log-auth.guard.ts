import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable, map, take, switchMap } from "rxjs";
import { UserDataService } from "./log-user-data.service";

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private m_UserDataService: UserDataService, private m_Router: Router) { }

  canActivate(route: ActivatedRouteSnapshot): boolean {/*
    return this.m_UserDataService.m_Token$.pipe(take(1), switchMap(token => {
      return this.m_UserDataService.m_UserData$.pipe(map(user_data => {
        return !!token ? this.checkRole(user_data?.role, route) : this.m_Router.createUrlTree(['/login']);
      }));
    }));*/
    return true
  }
  checkRole(role: number | undefined, route : ActivatedRouteSnapshot): boolean{
    if(!role) return false
    if(this.getRole(role) === route.url.toString())
      return true;

    return false;
  }
  getRole(role: number) : string{
    if(role==3)return 'admin';
    if(role==1)return 'admin-center';
    if(role==2)return 'user';
    
    return '';
  }
}