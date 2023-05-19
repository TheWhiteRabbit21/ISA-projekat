import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms'
import { AuthService, LoginDTO } from 'src/app/modules/pages/login/log-auth.service'
import { MatSnackBar } from '@angular/material/snack-bar'
import { catchError, of } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: UntypedFormGroup = this.formInstance;
  m_Errors: string[] = [];

  constructor(private m_AuthService: AuthService, private m_SnackBar: MatSnackBar, private m_Router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.m_Errors.length = 0;
    const dto: LoginDTO = this.loginForm.getRawValue();
    if (!this.loginForm.valid) return;

    this.m_AuthService.login(dto)
      .subscribe(data => {
        if(data){
          if(data.role == 2)this.m_Router.navigate(['/user']);
          if(data.role == 1)this.m_Router.navigate(['/admin-center']);    
          if(data.role == 3)this.m_Router.navigate(['/admin']);               
        }
      });
  }

  get formInstance(): UntypedFormGroup {
    return new UntypedFormGroup({
      'email': new UntypedFormControl(null, [Validators.required]),
      'password': new UntypedFormControl(null, [Validators.required])
    });
  }

  get email(){
    return this.loginForm.get('email');
  }

  get password(){
    return this.loginForm.get('password');
  }

  public register(){
    window.location.href="http://localhost:4200/register"
  }

}
