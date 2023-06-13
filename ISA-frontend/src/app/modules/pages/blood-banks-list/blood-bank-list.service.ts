import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BloodBank } from "./blood-banks-list.component";
import { Page } from "../../admin/pages/registered-users-list/registered-users-list.service";
import { BloodBankk } from "../../user/pages/reserve-predefined-appointment/reserve-predefined-appointment.component";

@Injectable({
    providedIn: 'any',
})
export class BloodBankListService {

    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }

    getAllBloodCenters(page : Page) : Observable<BloodBank[]> {
        return this.http.post<BloodBank[]>(this.route + 'api/centers/all', page, {headers: this.headers});
    }

    getAllBloodCenterss() : Observable<BloodBankk[]> {
        return this.http.get<BloodBankk[]>(this.route + 'api/centers/all', {headers: this.headers});
    }
}
