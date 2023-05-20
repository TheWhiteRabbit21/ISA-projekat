import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserDTO } from './userDTO';

@Injectable({
  providedIn: 'root'
})
export class RegisterUserService {

route: string = 'http://localhost:8084/';
headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
constructor(private http: HttpClient) { }

submit(registeringUser: UserDTO): Observable<Boolean> {
  return this.http.post<Boolean>(this.route + 'auth/signup', registeringUser, {headers: this.headers});
}

verifyEmail(username: String): Observable<Boolean> {
  return this.http.get<Boolean>(this.route + 'auth/verify-email/' + username, {headers: this.headers});
}
}
