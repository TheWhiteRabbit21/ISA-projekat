import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { tap } from 'rxjs/operators';
import { RegisterAdminService, AdminDTO } from './register-admin.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register-admin',
  templateUrl: './register-admin.component.html',
  styleUrls: ['./register-admin.component.scss']
})
export class RegisterAdminComponent implements OnInit {
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
  constructor(private registerAdminService: RegisterAdminService, private router: Router, private snackBar: MatSnackBar) { }
  ngOnInit(): void {
  }

  register(): void {
    const dto: AdminDTO = this.registerForm.getRawValue();
    if (!this.registerForm.valid) return;
    this.registerAdminService.register(dto).subscribe(res => {
      this.snackBar.open('Admin Created','Ok', {
        duration: 3000
      });
      
      this.router.navigate(['/admin']);
    });
  }
}
