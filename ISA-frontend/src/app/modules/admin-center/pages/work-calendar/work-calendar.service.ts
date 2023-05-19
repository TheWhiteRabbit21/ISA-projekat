import { Time } from '@angular/common';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Appointment{
  Id : number,
  Subject : string,
  StartTime : string,
  EndTime: string
}

@Injectable({
  providedIn: 'root'
})
export class WorkCalendarService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getAllAppointments() : Observable<Appointment[]> {
      return this.http.get<Appointment[]>(this.route + 'api/center-admins/appointments', {headers: this.headers});
  }
}
