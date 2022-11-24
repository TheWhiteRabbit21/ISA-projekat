import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


export class BloodDonor {
  bloodPast: boolean = false;
  everRejected: boolean = false;
  feelHealthy: boolean = false;
  ateSomething: boolean = false;
  haveDangerousJob: boolean = false;
  regularlyTakeMedicine: boolean = false;
  takenMedicineInLast3Days: boolean = false;
  AspirinLast5Days: boolean = false;
  hospitalEverOrNow: boolean = false;
  takenToothOutInLast7Days: boolean = false;
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
