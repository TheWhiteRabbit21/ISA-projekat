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
    bloodPast: false,
    everRejected: false,
    feelHealthy: false,
    ateSomething:  false,
    haveDangerousJob: false,
    regularlyTakeMedicine:  false,
    takenMedicineInLast3Days:  false,
    AspirinLast5Days: false,
    hospitalEverOrNow: false,
    takenToothOutInLast7Days: false,
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
