import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export class Admin{
    id: string = '';
    name: string = '';
    surname: string = '';
    password: string = '';
    email: string = '';
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
  export class UpdateAdminService {

    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }
  
    submit(admin: any): Observable<any> {
        return this.http.put<any>(this.route + 'api/center-admins/update', admin, {headers: this.headers});
    }
  }