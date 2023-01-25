import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Center } from "../../pages/admin-center-profile/admin-center-profile.service";
import { Admin } from "../../../pages/admin-profile/admin-profile.service";
import { User } from "../../../pages/user-profile/user";
import { Appointment } from "./Appointment";

@Component({
  selector: 'app-define-appointment',
  templateUrl: './define-appointment.component.html',
  styleUrls: ['./define-appointment.component.css']
})
export class DefineAppointmentComponent implements OnInit {

  public admin: any  = {} as Admin;
  public center: any = {} as Center;
  public appointment: any = {} as Appointment;

  constructor(private http: HttpClient,private router: Router) { }

  ngOnInit(): void {
  }

  public saveButton(): void {
    this.appointment = Object.assign({}, this.appointment);
    this.appointment.adminId = 1;

    console.log(this.appointment);
    var headers = new HttpHeaders({
    'Content-Type': 'application/json'
    });

    this.http.post("http://localhost:8084/api/center-admins/appointment/data", JSON.stringify(this.appointment),{headers:headers}).subscribe(res => {
      this.router.navigate(['/admin-center'])
    });

  }
}
