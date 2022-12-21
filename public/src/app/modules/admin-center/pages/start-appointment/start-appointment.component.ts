import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Params } from '@angular/router';
import { AppointmentInfo, AppointmentService } from './start-appointment.service';

@Component({
  selector: 'app-start-appointment',
  templateUrl: './start-appointment.component.html',
  styleUrls: ['./start-appointment.component.scss']
})
export class StartAppointmentComponent implements OnInit {

  id: number = 0;
  date = new Date();
  latest_date = this.datepipe.transform(this.date, 'dd-MM-yyyy');

  public appointmentInfo: AppointmentInfo = {
    datum: this.latest_date!,
    donorId: this.id,
    krvnaGrupa: '',
    napomenaDoktoruMedicine: '',
    bakarSulfat: '',
    hemoglobinometarVrednost: '',
    pluca: '',
    srce: '',
    TA: '',
    tipKese: '',
    napomena: '',
    brojLotaKese: '',
    kolicinaKrviDataML: '',
    brojIgala: ''
  }

  appointmentForm = new FormGroup({
    krvnaGrupa: new FormControl(),
    napomenaDoktoruMedicine: new FormControl(),
    bakarSulfat: new FormControl(),
    hemoglobinometarVrednost: new FormControl(),
    pluca: new FormControl(),
    srce: new FormControl(),
    TA: new FormControl(),
    tipKese: new FormControl(),
    napomena: new FormControl(),
    brojLotaKese: new FormControl(),
    kolicinaKrviDataML: new FormControl(),
    brojIgala: new FormControl()
  })

  constructor( private _route: ActivatedRoute,
                private _appointmentService : AppointmentService,
                private _snackBar : MatSnackBar,
                private datepipe: DatePipe) {}

  ngOnInit(): void {
    this._route.params
    .subscribe((params: Params) => {
      this.id = +params['id'];
      this.appointmentInfo.donorId = +params['id'];
      //console.log(this.id);
      // this._BBInfoService.getById(this.id).subscribe(
      //   res => (this.dataSource = res))
      });
  };

  submit() : void{
    this._appointmentService.submit(this.appointmentInfo).subscribe(res => {
      this._snackBar.open("Appointment successfully finished.", "Ok");
      setTimeout(() => {
        window.location.href="http://localhost:4200/admin-appointment/" + this.id
      }, 
      3000);
    });
  }




}
