import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { AdminAppointmentService } from './admin-appointment.service';

export interface BloodDonorInfo{
  name : string,
  surname : string,
  weight: string,
  skinIssues: string,
  healthy: string,
  bloodPressure: string,
  femalePeriod: string,
  underMedicationLast7Days: string,
  toothOutLast7Days: string,
  piercingLast6Months: string,
  operationOrTransfusionLast6Months: string,
  tattooLast6Months: string
}

export interface AppointmentHistoryInfo{
  datum: string,
  krvnaGrupa: string,
  napomenaDoktoruMedicine: string,
  bakarSulfat: string,
  hemoglobinometarVrednost: string,
  pluca: string,
  srce: string,
  TA: string,
  tipKese: string,
  napomena: string,
  brojLotaKese: string
}


@Component({
  selector: 'app-admin-appointment',
  templateUrl: './admin-appointment.component.html',
  styleUrls: ['./admin-appointment.component.scss']
})
export class AdminAppointmentComponent implements OnInit {
  
  id: number = 0;
  displayedColumns: string[] = ['name', 'surname'];
  displayedColumns2: string[] = ['question', 'answer'];
  displayedColumns3: string[] = ['datum', 'krvnaGrupa', 'napomenaDrMedicine', 'bakarSulfat', 'hemoglobinometarVrednost', 'pluca', 'srce', 'TA', 'tipKese', 'napomena', 'brojLotaKese'];
  dataSource: BloodDonorInfo[] = [];
  dataSource2: AppointmentHistoryInfo[] = [];

  constructor(private _route: ActivatedRoute,
              private _router: Router,
              private _adminAppointmentService: AdminAppointmentService) { }

  ngOnInit(): void {
    this._route.params
    .subscribe((params: Params) => {
      this.id = +params['id'];

      this._adminAppointmentService.getById(this.id).subscribe(
        res => (this.dataSource = res));
      
      this._adminAppointmentService.getAppointmentHistory(this.id).subscribe(
        res => (this.dataSource2 = res));
    });
  };

  startAppointment(): void {
    this._router.navigate(['/start-appointment/' + this.id]);
  }

  onBack(): void {
    this._router.navigate(['/admin-center']);
  }

  didntShowUp(): void {

  }

  doesntMeetRequirements(): void {
    this._router.navigate(['/admin-center']);
  }


}
