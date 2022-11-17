import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface RegisteringUser {
  email: string;
  password: string;
  name: string;
  surname: string;
  street: string;
  number: number;
  city: string;
  country: string;
  telephoneNumber: number;
  jmbg: number;
  gender: number;
  occupation: string;
  establishmentInfo: string;
}

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

route: string = 'http://localhost:8088/';
headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
constructor(private http: HttpClient) { }

submit(registeringUser: any): Observable<any> {
  return this.http.post<any>(this.route + 'api/users/add', registeringUser, {headers: this.headers});
}
}
