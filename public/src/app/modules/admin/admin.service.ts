import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export class PasswordDTO{
  password : string = ''
  id : number = 0
}
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getIfPasswordChanged(id: number) : Observable<boolean> {
      return this.http.post<boolean>(this.route + 'api/admins/changedPassword',id, {headers: this.headers});
  }

  changePassword(password : PasswordDTO) : Observable<boolean> {
    return this.http.post<boolean>(this.route + 'api/admins/changePassword', password ,{headers: this.headers});
  }
}

