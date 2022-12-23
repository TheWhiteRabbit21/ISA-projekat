import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getIfPasswordChanged() : Observable<boolean> {
      return this.http.get<boolean>(this.route + 'api/admins/changedPassword', {headers: this.headers});
  }

  changePassword(password : string) : Observable<boolean> {
    return this.http.post<boolean>(this.route + 'api/admins/changePassword', password ,{headers: this.headers});
  }
}

