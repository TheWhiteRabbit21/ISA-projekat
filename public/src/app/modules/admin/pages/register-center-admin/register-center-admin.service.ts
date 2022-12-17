import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export class CenterAdmin{
  email: string = '';
  password: string = '';  
  name: string = '';
  surname: string = '';
  gender: string = '';
  jmbg: number = 0;
  country: string = '';
  city: string = '';
  street: string = '';
  number: string = '';
  phoneNumber: string = '';
}
@Injectable({
  providedIn: 'root'
})
export class RegisterCenterAdminService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  submit(centerAdmin: any): Observable<any> {
      return this.http.post<any>(this.route + 'api/center-admins/', centerAdmin, {headers: this.headers});
  }
}