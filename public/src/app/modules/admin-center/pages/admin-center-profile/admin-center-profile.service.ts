import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export class Center{
    id: string = '';
    name: string = '';
    country: string = '';
    city: string = '';
    street: string = '';
    number: string = '';
    description: string = '';
  }

export class Appointment{
  id: string = '';
  date: string = '';
  time: string = '';
  durationMinutes: string = '';
  taken: boolean = false;
}

  @Injectable({
    providedIn: 'root'
  })
  export class UpdateCenterService {
  
    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }
  
    submit(center: any): Observable<any> {
        return this.http.put<any>(this.route + 'api/centers/update', center, {headers: this.headers});
    }
  }