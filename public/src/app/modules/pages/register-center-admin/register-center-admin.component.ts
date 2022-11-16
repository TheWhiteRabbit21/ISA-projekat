import { Component, OnInit } from '@angular/core';
import { CenterAdmin, RegisterCenterAdminService } from './register-center-admin.service';

@Component({
  selector: 'app-register-center-admin',
  templateUrl: './register-center-admin.component.html',
  styleUrls: ['./register-center-admin.component.css']
})
export class RegisterCenterAdminComponent implements OnInit {

  public centerAdmin : CenterAdmin = {
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    phoneNumber : '',
    surname : '',
    email : '',
    password : '',
    jmbg : 0,
    gender : ''
  }
  constructor(private registerCenterAdminService : RegisterCenterAdminService) { }

  ngOnInit(): void {
  }

  submit(): void {
    this.registerCenterAdminService.submit(this.centerAdmin).subscribe(res => {
      console.log(res)
    });
  }
}
