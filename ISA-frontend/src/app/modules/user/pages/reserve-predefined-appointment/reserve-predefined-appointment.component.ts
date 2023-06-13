import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { BloodBankListService } from 'src/app/modules/pages/blood-banks-list/blood-bank-list.service';

export interface BloodBank {
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

  public bloodbanks: BloodBank[] = [];
  displayedColumns: string[] = ['name', 'averagePoints', 'city', 'country', 'description', 'predefinedAppointments'];
  public dataSource = new MatTableDataSource(this.bloodbanks);
  
  constructor(private _bloodBankService: BloodBankListService) { }

  ngOnInit() {
    this.getBloodCenters();
  }

  public getBloodCenters(){
    this._bloodBankService.getAllBloodCenterss().subscribe(res => {
      this.bloodbanks = res;
      this.dataSource = new MatTableDataSource(this.bloodbanks);
    })
  }

}
