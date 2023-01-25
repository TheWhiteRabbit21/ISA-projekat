import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export class RegisteringUser {
  email: string = '';
  password: string = '';
  name: string = '';
  surname: string = '';
  street: string = '';
  number: number | undefined;
  city: string = '';
  state: string = '';
  phoneNumber: number| undefined;
  jmbg: number | undefined;
  gender: number = 0;
  occupation: string = '';
  establishmentInfo: string = '';
}

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

route: string = 'http://localhost:8084/';
headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
constructor(private http: HttpClient) { }

submit(registeringUser: any): Observable<any> {
  return this.http.post<any>(this.route + 'auth/signup', registeringUser, {headers: this.headers});
}
}
