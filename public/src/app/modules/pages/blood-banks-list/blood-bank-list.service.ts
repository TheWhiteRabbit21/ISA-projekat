import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { BloodBank } from "./blood-banks-list.component";

@Injectable({
    providedIn: 'any',
})
export class BloodBankListService {

    route: string = 'http://localhost:8088/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }

    getAllBloodCenters() : Observable<BloodBank[]> {
        return this.http.get<BloodBank[]>(this.route + 'api/centers/all', {headers: this.headers});
    }
}
