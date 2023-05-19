import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface ComplaintDTO{
  id : number;
  complaint: string;
  response: string;
}

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {
  route: string = 'http://localhost:8084/';
  headers: HttpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient) { }

  getAllUnanswered(): Observable<ComplaintDTO[]> {
    return this.http.get<ComplaintDTO[]>(this.route + 'api/admins/unanswered', {headers: this.headers});
  }

  answer(complaintDTO: ComplaintDTO): Observable<any> {
      return this.http.post<any>(this.route + 'api/admins/answer', complaintDTO, {headers: this.headers});
  } 
}