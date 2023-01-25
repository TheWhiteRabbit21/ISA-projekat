import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MATERIAL_SANITY_CHECKS } from '@angular/material/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Reservation } from './Reservation';
import { CenterService } from './reserve-appointment-list.service';

export interface BloodBank {
  id: number;
  name: string;
  averageRating: number;
  city: string;
}
@Component({
  selector: 'app-reserve-appointment',
  templateUrl: './reserve-appointment.component.html',
  styleUrls: ['./reserve-appointment.component.scss']
})
export class ReserveAppointmentComponent implements OnInit {
  cities: string[] = [];
  public reservation: any = {} as Reservation;
  public bloodbanks: BloodBank[] = [];
  public dataSource = new MatTableDataSource(this.bloodbanks);
  displayedColumns: string[] = ['name', 'averagePoints', 'city'];

  constructor(private http: HttpClient,private router: Router, private bloodBankCenterService: CenterService) { }

  ngOnInit(): void {

    console.log("INISLAJZ");
  }

  reserveButton() {
    this.reservation= Object.assign({}, this.reservation);
    console.log(this.reservation);
    var headers = new HttpHeaders({
      'Content-Type': 'application/json'
      });
    //this.http.post("http://localhost:8084/api/center-admins/appointment/reserve", JSON.stringify(this.reservation),{headers:headers}).subscribe(res => {
        //this.router.navigate(['/admin-center'])
      //});

      this.getNeededCenters();
  }

  public getNeededCenters(){
    console.log("STARTFUNKSN");
    this.bloodBankCenterService.getNeededBloodCenters(this.reservation).subscribe(res=> {
      console.log("MIDDLEFUNCTION");
      this.bloodbanks = res;
      this.dataSource = new MatTableDataSource(this.bloodbanks);
      // this.dataSource.sort = this.sort;
      // for(let i = 0; i<this.bloodbanks.length; i++){
      //   this.cities.push(this.bloodbanks[i].city);
      // }
      console.log(res);
      console.log("ADFASDFSDFSDFSDFSDF");
    })

  }
  reserveAppointment( bloodbank:BloodBank){
    this.reservation.bloodBankId = bloodbank.id;
    this.bloodBankCenterService.reserveAppointment(this.reservation).subscribe(res => {
      this.router.navigate(['/user']);
    })
  }
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

}
