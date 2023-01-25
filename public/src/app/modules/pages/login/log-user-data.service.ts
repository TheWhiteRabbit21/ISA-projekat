import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs";

export interface User {
  UserId: number;
  Username: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserDataService{
  private m_TokenSubject: BehaviorSubject<null | string> = new BehaviorSubject<null | string>(null);
  private m_UserDataSubject: BehaviorSubject<null | User> = new BehaviorSubject<null | User>(null);

  public m_Token$ = this.m_TokenSubject.asObservable();
  public m_UserData$ = this.m_UserDataSubject.asObservable();

  constructor(){
    const token = localStorage.getItem('token');
    if(token){
      this.setToken = token;
    }
  }

  set setToken(token: null | string){
    console.log("Usao sam.")
    if(token){
      this.m_TokenSubject.next(token);
      localStorage.setItem('token', token);
      console.log("Usao sam i setovao.")
    }else{
      this.m_TokenSubject.next(null);
      localStorage.removeItem('token');
      console.log("Usao sam i obrisao.")
    }
  }
  set setUserData(userData: null | User){
    this.m_UserDataSubject.next(userData);
  }
}