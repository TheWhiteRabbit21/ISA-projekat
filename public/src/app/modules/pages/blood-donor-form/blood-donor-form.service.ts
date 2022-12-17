import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


export class BloodDonor {
  weight: boolean = false;
  skinIssues: boolean = false;
  feelHealthy: boolean = false;
  bloodPressure: boolean = false;
  menstruation: boolean = false;
  toothOutLast7Days: boolean = false;
  takenMedicineInLast7Days: boolean = false;
  piercingLast6Months: boolean = false;
  operationOrTransfusionLast6Months: boolean = false;
  tattooLast6Months: boolean = false;
}

@Injectable({
  providedIn: 'root'
})
export class BloodDonorFormService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }
  
  submit(bloodDonorInfo: any): Observable<any> {
    return this.http.post<any>(this.route + 'api/bloodDonorInfo/add', bloodDonorInfo, {headers: this.headers});
  }

}
