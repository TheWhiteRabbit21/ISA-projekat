import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { BloodBankListService } from 'src/app/modules/pages/blood-banks-list/blood-bank-list.service';

export interface BloodBankk {
  id: number;
  name: string;
  averagePoints: number;
  city: string;
  country: string;
  description: string;
}

@Component({
  selector: 'app-reserve-predefined-appointment',
  templateUrl: './reserve-predefined-appointment.component.html',
  styleUrls: ['./reserve-predefined-appointment.component.css']
})
export class ReservePredefinedAppointmentComponent implements OnInit {

  public bloodbanks: BloodBankk[] = [];
  displayedColumns: string[] = ['name', 'averagePoints', 'city', 'country', 'description', 'predefinedAppointments'];
  public dataSource = new MatTableDataSource(this.bloodbanks);
  ruta: string = "";
  
  constructor(private router: Router, private _bloodBankService: BloodBankListService) { }

  ngOnInit() {
    this.getBloodCenters();
  }

  public getBloodCenters(){
    this._bloodBankService.getAllBloodCenterss().subscribe(res => {
      this.bloodbanks = res;
      this.dataSource = new MatTableDataSource(this.bloodbanks);
    })
  }

  public predefined(centerId: number){
    this.ruta = "http://localhost:4200/predefined-appointments/" + centerId;
    window.location.href = this.ruta;
    console.log(this.ruta);
  }

}
