import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BloodDonor, BloodDonorFormService } from './blood-donor-form.service';

@Component({
  selector: 'app-blood-donor-form',
  templateUrl: './blood-donor-form.component.html',
  styleUrls: ['./blood-donor-form.component.css']
})
export class BloodDonorFormComponent implements OnInit {

  public bloodDonorInfo: BloodDonor = {
    weight: false,
    skinIssues: false,
    feelHealthy: false,
    bloodPressure:  false,
    menstruation: false,
    toothOutLast7Days:  false,
    takenMedicineInLast7Days:  false,
    piercingLast6Months: false,
    operationOrTransfusionLast6Months: false,
    tattooLast6Months: false,
  }

  constructor(private _bloodDonorFormService : BloodDonorFormService, private _snackBar : MatSnackBar) { }

  ngOnInit() {
  }

  submit() : void{
    this._bloodDonorFormService.submit(this.bloodDonorInfo).subscribe(res => {
      this._snackBar.open("Form successfully sent.", "Ok");
      setTimeout(() => {
        window.location.href="http://localhost:4200/home"
      }, 
      3000);
    });
  }
}
