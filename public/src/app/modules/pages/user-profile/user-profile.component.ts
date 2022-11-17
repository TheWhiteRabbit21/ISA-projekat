import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { User } from './user';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public user: any  = {} as User;
  editedUser: any = {} as User;

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    //ovde dobavis podatke iz bekenda


    this.http.get("http://localhost:8084/api/users/find/1").subscribe(res => {
      this.user = res;
      this.editedUser = Object.assign({}, this.user);
      console.log(this.user);
    });

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
    //this.user = Object.assign({}, this.editedUser);

    var headers = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    this.http.put("http://localhost:8084/api/users/edit", JSON.stringify(this.editedUser),{headers:headers}).subscribe(res => {
      this.user = res;
      console.log(res);
    });

  }


}
