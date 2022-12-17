import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Center } from "../admin-center-profile/admin-center-profile.service";
import { Admin } from "../admin-profile/admin-profile.service";
import { User } from "../user-profile/user";
import { Appointment } from "./Appointment";

@Component({
  selector: 'app-admin-appointment',
  templateUrl: './admin-appointment.component.html',
  styleUrls: ['./admin-appointment.component.css']
})
export class AdminAppointmentComponent implements OnInit {

  public admin: any  = {} as Admin;
  public center: any = {} as Center;
  public appointment: any = {} as Appointment;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    //dobaviti podatke s bekenda
  }

  public saveButton(): void {
    // this.appointment = Object.assign({}, this.editedUser);

    // var headers = new HttpHeaders({
    //   'Content-Type': 'application/json'
    // });

    // this.http.post("http://localhost:8084/api/users/edit", JSON.stringify(this.editedUser),{headers:headers}).subscribe(res => {
    //   this.user = res;
    //   console.log(res);
    // });

  }
}
