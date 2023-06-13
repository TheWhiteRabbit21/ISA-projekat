import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { PredefinedAppointmentsCenterService } from 'src/app/modules/pages/predefined-appointments-center/predefined-appointments-center.service';

export interface Appointment {
  id: number,
  date: string,
  duration: string,
  time: string
}

@Component({
  selector: 'app-reserved-appointments',
  templateUrl: './reserved-appointments.component.html',
  styleUrls: ['./reserved-appointments.component.css']
})
export class ReservedAppointmentsComponent implements OnInit {

  public appointments: Appointment[] = [];
  displayedColumns: string[] = ['date', 'time', 'duration', 'reserve'];
  public dataSource = new MatTableDataSource(this.appointments);
  
  constructor(private _predefinedAppointmentsCenterService: PredefinedAppointmentsCenterService) { }

  ngOnInit() {
    this.getReservedAppointmentsForUser();
  }

  public getReservedAppointmentsForUser(){
      this._predefinedAppointmentsCenterService.getReservedAppointmentsForUser().subscribe(res => {
      this.appointments = res;
      this.dataSource = new MatTableDataSource(this.appointments);
    })
  }

  public cancel(appointmentId: number){
    this._predefinedAppointmentsCenterService.cancel(appointmentId).subscribe(res =>{
      if(res === true){
        alert("Succesfully cancelled your appointment.");
      }else{
        alert("You can't cancel your appointment. It is in less than 24 hours.")
      }
      });
  }

}
