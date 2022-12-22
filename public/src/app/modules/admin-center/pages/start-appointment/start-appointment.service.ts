import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export class AppointmentInfo {
    datum: string = '';
    donorId: number = 0;
    krvnaGrupa: string = '';
    napomenaDoktoruMedicine: string = '';
    bakarSulfat: string = '';
    hemoglobinometarVrednost: string = '';
    pluca: string = '';
    srce: string = '';
    TA: string = '';
    tipKese: string = '';
    napomena: string = '';
    brojLotaKese: string = '';
    kolicinaKrviDataML: string = '';
    brojIgala: string = '';
}

@Injectable({
    providedIn: 'root'
})
export class AppointmentService {

    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }
    
    submit(appointmentInfo: any): Observable<any> {
      return this.http.post<any>(this.route + 'api/appointments/add', appointmentInfo, {headers: this.headers});
    }


}