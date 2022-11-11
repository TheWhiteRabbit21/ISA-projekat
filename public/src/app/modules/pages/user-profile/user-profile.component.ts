import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  user  = {
    name: "Milos",
    surname: "Obilic",
    id:"0304000230023",
    gender:"male",
    email:"asdf@gmail.com",
    address:"ulica 12",
    city:"Paracin",
    state:"Srbija",
    phone:"0611234123",
    points:"3",
    category:"2"
  };

  editedUser = Object.assign({}, this.user);
  constructor() { }

  ngOnInit(): void {
    //ovde dobavis podatke iz bekenda


    // console.log(user);
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

  }


}
