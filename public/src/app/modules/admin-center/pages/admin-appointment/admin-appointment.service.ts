import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BloodDonorInfo } from "./admin-appointment.component";

@Injectable({
    providedIn: 'root'
})
export class AdminAppointmentService {
    
    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }

    public getById(id : any) : Observable<BloodDonorInfo[]> {
        return this.http.post<BloodDonorInfo[]>(this.route + 'api/users/findBloodDonorInfo/', id, {headers: this.headers});
      }
}