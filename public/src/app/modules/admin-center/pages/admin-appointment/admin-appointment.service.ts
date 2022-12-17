import { HttpHeaders, HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface User{
    id : number,
    name : string,
    surname : string,
    jmbg : string,
    email : string
    //dodati za upitnik sta sve treba u model pa prikazati u htmlu
    //promeniti na backendu u DTO-u sta se sve salje nazad u frontend
  }

@Injectable({
    providedIn: 'root'
})
export class AdminAppointmentService {
    
    route: string = 'http://localhost:8084/';
    headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    constructor(private http: HttpClient) { }

    getById(id : any) : Observable<User> {
        return this.http.post<User>(this.route + 'api/users/find/', id, {headers: this.headers});
      }





}