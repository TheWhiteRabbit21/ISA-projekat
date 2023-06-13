import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PredefinedAppointmentsCenterService } from './predefined-appointments-center.service';
import { ActivatedRoute, Params } from '@angular/router';

export interface Appointment {
  id: number,
  date: string,
  duration: string,
  time: string
}

@Component({
  selector: 'app-predefined-appointments-center',
  templateUrl: './predefined-appointments-center.component.html',
  styleUrls: ['./predefined-appointments-center.component.css']
})
export class PredefinedAppointmentsCenterComponent implements OnInit {

  public appointments: Appointment[] = [];
  displayedColumns: string[] = ['date', 'time', 'duration', 'reserve'];
  public dataSource = new MatTableDataSource(this.appointments);
  public id: number = 0;
  
  constructor(private _predefinedAppointmentsCenterService: PredefinedAppointmentsCenterService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getPredefinedAppointmentsForCenter();
  }

  public getPredefinedAppointmentsForCenter(){
    this.route.params.subscribe((params: Params)=>{
      this.id = params['id']
      this._predefinedAppointmentsCenterService.getPredefinedAppointmentsForCenter(this.id).subscribe(res => {
      this.appointments = res;
      this.dataSource = new MatTableDataSource(this.appointments);
    })
   })
  }

  public reserve(appointmentId: number){
    this._predefinedAppointmentsCenterService.reserve(appointmentId).subscribe(res =>
      {
        alert("Succesfully reserved your appointment.");
      });
  }

}
