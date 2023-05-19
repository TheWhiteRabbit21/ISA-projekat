import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export class AdminDTO{
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
export class RegisterAdminService {
  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  register(adminDTO: AdminDTO): Observable<any> {
      return this.http.post<any>(this.route + 'api/admins/', adminDTO, {headers: this.headers});
  } 
}
