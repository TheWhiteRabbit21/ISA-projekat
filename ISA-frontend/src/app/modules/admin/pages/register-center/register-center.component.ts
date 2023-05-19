import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UpdateAdminService } from 'src/app/modules/pages/admin-profile/admin-profile.service';
import { Admin, Center, RegisterCenterService } from './register-center.service';

@Component({
  selector: 'app-register-center',
  templateUrl: './register-center.component.html',
  styleUrls: ['./register-center.component.scss']
})
export class RegisterCenterComponent implements OnInit {

  public center : Center = {
    id : '',
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    description : '',
    admins: []
  }

  public centerAdmins : Admin[] = []

  registerForm = new UntypedFormGroup({
    name: new UntypedFormControl(null, [Validators.required]),
    admins: new UntypedFormControl(null, [Validators.required]),
    description: new UntypedFormControl(null, [Validators.required]),
    country: new UntypedFormControl(null, [Validators.required]),
    city: new UntypedFormControl(null, [Validators.required]),
    street: new UntypedFormControl(null, [Validators.required]),
    number: new UntypedFormControl(null, [Validators.required])
  })
  constructor(private registerCenterService: RegisterCenterService, private router: Router, private snackBar: MatSnackBar) { }
  ngOnInit(): void {
    this.registerCenterService.getAdmins().subscribe(res => {
      this.centerAdmins = res;
    });

  }

  register(): void {
    const dto: Center = this.registerForm.getRawValue();
    if (!this.registerForm.valid) return;
    this.registerCenterService.submit(dto).subscribe(res => {
      this.snackBar.open('Admin Created','Ok', {
        duration: 3000
      });
      
      this.router.navigate(['/admin']);
    });
  }
}
