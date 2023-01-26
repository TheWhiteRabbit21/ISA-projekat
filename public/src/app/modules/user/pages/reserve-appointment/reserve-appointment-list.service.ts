import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Reservation } from "./Reservation";

import { BloodBank } from "./reserve-appointment.component";

@Injectable({
  providedIn: 'any',
})
export class CenterService{

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json'});
  constructor(private http: HttpClient){ }

  getNeededBloodCenters(reservation: Reservation) : Observable<BloodBank[]>{
    return this.http.post<BloodBank[]>("http://localhost:8084/api/center-admins/appointment/reserve", JSON.stringify(reservation),{headers:this.headers});
  }
  reserveAppointment(reservation: Reservation) : Observable<any>{
    return this.http.post<any>("http://localhost:8084/api/center-admins/appointment/take", JSON.stringify(reservation),{headers:this.headers});
  }
}
