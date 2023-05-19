import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { RegisterUserService } from './register-user.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserDTO } from './userDTO';

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
    username: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', Validators.required),
    confirmPassword: new FormControl('', Validators.required),
    name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    surname: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+$')]),
    street: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]+$')]),
    number: new FormControl('', [Validators.required, Validators.pattern('[A-Z0-9]+$')]),
    city: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]+$')]),
    country: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z ]+$')]),
    phoneNumber: new FormControl('', [Validators.required, Validators.pattern('[0-9]+$')]),
    jmbg: new FormControl('', [Validators.required, Validators.pattern('[0-9]{13}$')]),
    gender: new FormControl('', Validators.required),
    occupation: new FormControl('', Validators.required),
    establishmentInfo: new FormControl('', Validators.required)
  },[ CustomValidators.MatchValidator('password', 'confirmPassword') ])

  constructor(private _registerUserService : RegisterUserService, private _snackBar : MatSnackBar) { }

  ngOnInit() {
  }

  register() : void{

    let username = this.registerUserForm.get("username")?.value
    let password = this.registerUserForm.get("password")?.value
    let name = this.registerUserForm.get("name")?.value
    let surname = this.registerUserForm.get("surname")?.value
    let street = this.registerUserForm.get("street")?.value
    let numberstr = this.registerUserForm.get("number")?.value
    let city = this.registerUserForm.get("city")?.value
    let country = this.registerUserForm.get("country")?.value
    let phoneNumber = this.registerUserForm.get("phoneNumber")?.value
    let jmbg = this.registerUserForm.get("jmbg")?.value
    let gender = this.registerUserForm.get("gender")?.value
    let occupation = this.registerUserForm.get("occupation")?.value
    let establishmentInfo = this.registerUserForm.get("establishmentInfo")?.value
    let user: UserDTO = {
      username: username ? username : '',
      password: password ? password : '',
      name: name ? name : '',
      surname: surname ? surname : '',
      street: street ? street : '',
      number: numberstr ? numberstr : '',
      city: city ? city : '',
      country: country ? country : '',
      phoneNumber: phoneNumber ? phoneNumber : '',
      jmbg: jmbg ? jmbg : '',
      gender: Number(gender),
      occupation: occupation ? occupation : '',
      establishmentInfo: establishmentInfo ? establishmentInfo : '',
    }
    console.log(user)
    this._registerUserService.submit(user).subscribe(res => {
      if (res === true) {
        this._snackBar.open("Registration successful. Verify email so you can log into your account.", "Ok");
        this.registerUserForm.reset( { } );
        } else {
          this._snackBar.open("Email already in use, try another.", "Ok");
        }
    });
  };

  get email(){
    return this.registerUserForm.get('username');
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

  public login(){
    window.location.href="http://localhost:4200/login"
  }

}
