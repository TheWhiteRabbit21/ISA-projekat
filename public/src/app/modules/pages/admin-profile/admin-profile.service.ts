import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export class Admin{
    id: string = '';
    name: string = '';
    surname: string = '';
    email: string = '';
    gender: string = '';
    jmbg: string = '';
    state: string = '';
    city: string = '';
    street: string = '';
    streetNumber: string = '';
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
        return this.http.put<any>(this.route + 'api/users/update', admin, {headers: this.headers});
    }
  }