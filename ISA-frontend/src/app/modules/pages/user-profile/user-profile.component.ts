import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { map, Observable, switchMap, tap } from 'rxjs';
import { UserDataService } from 'src/app/modules/pages/login/log-user-data.service';
import { User } from './user';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
  public id : number = 1;
  public user: any  = {} as User;
  editedUser: any = {} as User;
  closeModalEvent: any;

  constructor(private http: HttpClient, private m_UserDataService : UserDataService) { }

  ngOnInit(): void {
    //ovde dobavis podatke iz bekenda
    this.getId().subscribe(res => {
      console.log('Usao')
    });
  }
  getId() : Observable<any>{
    return this.m_UserDataService.m_UserData$.pipe(tap(user_data=> {
      if(user_data) this.id = user_data.id;
    }),switchMap(_ => this.getUser()));
  }
  getUser() : Observable<any>{
    console.log('Usao');
    return  this.getLoggedUser().pipe(tap(res => {
      this.user = res;
      this.editedUser = Object.assign({}, this.user);
      //this.user;
    }));
  }
  getLoggedUser() : Observable<User>{
    return this.http.get<User>("http://localhost:8084/api/users/find/"+this.id);
  }

  public onOpenModal( mode: string): void {

    const container = document.getElementById('main-container');
    // console.log("KONTEJENR",container);
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'edit'){
      button.setAttribute('data-target', '#editData');
    }
    if(container != null){
      container.appendChild(button);
    }

    button.click();
  }

  public saveButton(): void {
    this.user = Object.assign({}, this.editedUser);

    var headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.put("http://localhost:8084/api/users/edit", JSON.stringify(this.editedUser),{headers:headers}).subscribe(res => {
      this.user = res;
      console.log(res);
    });

  }



}
