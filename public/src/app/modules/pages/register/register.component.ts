import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { RegisteringUser, RegisterUserService } from './register-user.service';
import {MatSnackBar} from '@angular/material/snack-bar';

export class CustomValidators {
  static MatchValidator(source: string, target: string): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const sourceCtrl = control.get(source);
      const targetCtrl = control.get(target);

      return sourceCtrl && targetCtrl && sourceCtrl.value !== targetCtrl.value
        ? { mismatch: true }
        : null;
    };
  }
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerUserForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required),
    confirmPassword: new FormControl('', Validators.required),
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    surname: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    street: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]+$')]),
    number: new FormControl('', [Validators.required, Validators.pattern('[A-Z0-9]+$')]),
    city: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    country: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$')]),
    jmbg: new FormControl('', [Validators.required, Validators.pattern('[0-9]{13}$')]),
    gender: new FormControl('', Validators.required),
    occupation: new FormControl('', Validators.required),
    establishmentInfo: new FormControl('', Validators.required)
  },[ CustomValidators.MatchValidator('password', 'confirmPassword') ])

  constructor(private _registerUserService : RegisterUserService, private _snackBar : MatSnackBar) { }

  ngOnInit() {
  }

  get email(){
    return this.registerUserForm.get('email');
  }

  get password(){
    return this.registerUserForm.get('password');
  }

  get confirmPassword(){
    return this.registerUserForm.get('confirmPassword');
  }

  get name(){
    return this.registerUserForm.get('name');
  }

  get surname(){
    return this.registerUserForm.get('surname');
  }

  get street(){
    return this.registerUserForm.get('street');
  }

  get number(){
    return this.registerUserForm.get('number');
  }

  get city(){
    return this.registerUserForm.get('city');
  }

  get country(){
    return this.registerUserForm.get('country');
  }

  get phoneNumber(){
    return this.registerUserForm.get('phoneNumber');
  }

  get jmbg(){
    return this.registerUserForm.get('jmbg');
  }

  get occupation(){
    return this.registerUserForm.get('occupation');
  }

  get establishmentInfo(){
    return this.registerUserForm.get('establishmentInfo');
  }

  get passwordMatchError() {
    return (
      this.registerUserForm.getError('mismatch') &&
      this.registerUserForm.get('confirmPassword')?.touched
    );
  }

 /* submit() : void{
    this._registerUserService.submit(this.registeringUser).subscribe(res => {
      this._snackBar.open("Registration successful.", "Ok");
      setTimeout(() => {
        window.location.href="http://localhost:4200/login"
      }, 
      3000);
    });
  }*/

}
