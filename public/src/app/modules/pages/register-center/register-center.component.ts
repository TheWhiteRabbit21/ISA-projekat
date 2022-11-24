import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UpdateAdminService } from '../admin-profile/admin-profile.service';
import { Admin, Center, RegisterCenterService } from './register-center.service';

@Component({
  selector: 'app-register-center',
  templateUrl: './register-center.component.html',
  styleUrls: ['./register-center.component.css']
})
export class RegisterCenterComponent implements OnInit {

  public center : Center = {
    id : '',
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    description : '',
    admins: []
  }

  constructor(private registerCenterService : RegisterCenterService) { }
  
  public centerAdmins : Admin[] = []
  public pom : Admin[] = []

  ngOnInit(): void {
    this.registerCenterService.getAdmins().subscribe(res => {
      this.centerAdmins = res;
    });
  }
  add(admin : Admin) : void {
    const index = this.centerAdmins.indexOf(admin);
    this.centerAdmins.splice(index, 1);
    this.pom.push(admin);
    this.center.admins.push(admin.id);
  }
  remove(admin : Admin) : void {
    const index = this.pom.indexOf(admin);
    this.pom.splice(index, 1);
    this.centerAdmins.push(admin);
    const ind = this.center.admins.indexOf(admin.id);
    this.center.admins.splice(ind, 1);
  }
  submit() : void{
    this.registerCenterService.submit(this.center).subscribe(res => {
      window.location.href="http://localhost:4200/admin-dashboard"
    });
  }

}
