import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

export class Center{
  id: string = '';
  name: string = '';
  country: string = '';
  city: string = '';
  street: string = '';
  number: string = '';
  description: string = '';
}
@Injectable({
  providedIn: 'root'
})
export class RegisterCenterService {

  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  submit(center: any): Observable<any> {
      return this.http.post<any>(this.route + 'api/centers', center, {headers: this.headers});
  }
}
