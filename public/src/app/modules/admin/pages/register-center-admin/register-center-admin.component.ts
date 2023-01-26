import { Component, OnInit } from '@angular/core';
import { UntypedFormGroup, UntypedFormControl, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { CenterAdmin, RegisterCenterAdminService } from './register-center-admin.service';

@Component({
  selector: 'app-register-center-admin',
  templateUrl: './register-center-admin.component.html',
  styleUrls: ['./register-center-admin.component.scss']
})
export class RegisterCenterAdminComponent implements OnInit {

  public centerAdmin : CenterAdmin = {
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    phoneNumber : '',
    surname : '',
    email : '',
    password : '',
    jmbg : 0,
    gender : ''
  }
  genders: string[] = [
    'Male',
    'Female'
  ];
  registerForm = new UntypedFormGroup({
    email: new UntypedFormControl(null, [Validators.required, Validators.email]),
    name: new UntypedFormControl(null, [Validators.required]),
    surname: new UntypedFormControl(null, [Validators.required]),
    password: new UntypedFormControl(null, [Validators.required]),
    gender: new UntypedFormControl(null, [Validators.required]),
    jmbg: new UntypedFormControl(null, [Validators.required]),
    phoneNumber: new UntypedFormControl(null, [Validators.required]),
    country: new UntypedFormControl(null, [Validators.required]),
    city: new UntypedFormControl(null, [Validators.required]),
    street: new UntypedFormControl(null, [Validators.required]),
    number: new UntypedFormControl(null, [Validators.required])
  })
  constructor(private registerAdminService: RegisterCenterAdminService, private router: Router, private snackBar: MatSnackBar) { }
  ngOnInit(): void {
  }

  register(): void {
    const dto: CenterAdmin = this.registerForm.getRawValue();
    if (!this.registerForm.valid) return;
    this.registerAdminService.submit(dto).subscribe(res => {
      this.snackBar.open('Admin Created','Ok', {
        duration: 3000
      });
      
      this.router.navigate(['/admin']);
    });
  }
}
