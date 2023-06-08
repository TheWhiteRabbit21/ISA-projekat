import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BloodBank } from "./blood-banks-list.component";
import { Page } from "../../admin/pages/registered-users-list/registered-users-list.service";

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
}
