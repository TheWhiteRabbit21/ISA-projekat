import { Component, OnInit } from '@angular/core';
import { RegisteringUser, RegisterUserService } from './register-user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  public registeringUser: RegisteringUser = {
    email: '',
    password: '',
    name: '',
    surname: '',
    street: '',
    number: 0,
    city: '',
    state: '',
    phoneNumber: 0,
    jmbg: 0,
    gender: 0,
    occupation: '',
    establishmentInfo: '',
  }

  constructor(private _registerUserService : RegisterUserService) { }

  ngOnInit() {
  }

  submit() : void{
    this._registerUserService.submit(this.registeringUser).subscribe(res => {

    });
  }

}
