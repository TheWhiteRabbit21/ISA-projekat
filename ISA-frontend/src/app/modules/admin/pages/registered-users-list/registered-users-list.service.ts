import { HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

export interface User{
  name : string,
  surname : string,
  jmbg : string,
  email : string
}
export interface Search{
  name: string,
  surname: string
}
export class Page{
  pageSize: number = 0;
  pageIndex: number = 0;
}
@Injectable({
  providedIn: 'root'
})
export class RegisteredUsersListService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getAllUsers(page : Page) : Observable<User[]> {
      return this.http.post<User[]>(this.route + 'api/users/all', page, {headers: this.headers});
  }
  search(search : any) : Observable<User[]> {
    return this.http.post<User[]>(this.route + 'api/users/search/', search, {headers: this.headers});
}
}
