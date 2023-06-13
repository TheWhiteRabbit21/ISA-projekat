import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PredefinedAppointmentsCenterService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

getPredefinedAppointmentsForCenter(id: number): Observable<any>{
  return this.http.get<any>(this.route + 'api/users/all-predefined-appointments/' + id, {headers: this.headers});
}

}
