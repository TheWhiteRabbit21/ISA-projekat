import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AdminAppointmentService } from './admin-appointment.service';

export interface BloodDonorInfo{
  id : number,
  name : string,
  surname : string
  //dodati za upitnik sta sve treba u model pa prikazati u htmlu
  //promeniti na backendu u DTO-u sta se sve salje nazad u frontend
}

@Component({
  selector: 'app-admin-appointment',
  templateUrl: './admin-appointment.component.html',
  styleUrls: ['./admin-appointment.component.scss']
})
export class AdminAppointmentComponent implements OnInit {
  
  id: number = 0;
  displayedColumns: string[] = ['question', 'answer'];
  dataSource: BloodDonorInfo[] = [];

  constructor(private _route: ActivatedRoute,
              private _router: Router,
              private _BBInfoService: AdminAppointmentService) { }

  ngOnInit(): void {
    this._route.params
    .subscribe((params: Params) => {
      this.id = +params['id'];
      //console.log(this.id);
      this._BBInfoService.getById(this.id).subscribe(
        res => (this.dataSource = res))
      });
  };

  onBack(): void {
    this._router.navigate(['/admin-center']);
  }

  didntShowUp(): void {

  }

  doesntMeetRequirements(): void {

  }


}
