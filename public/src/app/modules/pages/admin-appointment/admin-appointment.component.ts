import { HttpClient } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";




@Component({
  selector: 'app-admin-appointment',
  templateUrl: './admin-appointment.component.html',
  styleUrls: ['./admin-appointment.component.css']
})
export class AdminAppointmentComponent implements OnInit {



  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    //dobaviti podatke s bekenda
  }
}
