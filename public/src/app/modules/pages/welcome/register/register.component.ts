import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn } from '@angular/forms';
import { RegisteringUser, RegisterUserService } from './register-user.service';

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

  public registeringUser: RegisteringUser = {
    email: '',
    password: '',
    name: '',
    surname: '',
    street: '',
    number: 0,
    city: '',
    state: '',
    phoneNumber: 0,
    jmbg: 0,
    gender: 0,
    occupation: '',
    establishmentInfo: '',
  }

  registerUserForm = new FormGroup(
  {
    email: new FormControl(),
    password: new FormControl(),
    confirmPassword: new FormControl(),
    name: new FormControl(),
    surname: new FormControl(),
    street: new FormControl(),
    number: new FormControl(),
    city: new FormControl(),
    state: new FormControl(),
    phoneNumber: new FormControl(),
    jmbg: new FormControl(),
    gender: new FormControl(),
    occupation: new FormControl(),
    establishmentInfo: new FormControl()
  },
   [CustomValidators.MatchValidator('password', 'confirmPassword')]
  )

  constructor(private _registerUserService : RegisterUserService) { }

  ngOnInit() {
  }

  get passwordMatchError() {
    return (
      this.registerUserForm.getError('mismatch') &&
      this.registerUserForm.get('confirmPassword')?.touched
    );
  }

  submit() : void{
    this._registerUserService.submit(this.registeringUser).subscribe(res => {

    });
  }

}
