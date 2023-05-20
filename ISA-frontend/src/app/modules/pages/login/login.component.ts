import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormGroup, Validators } from '@angular/forms'
import { AuthService, LoginDTO } from 'src/app/modules/pages/login/log-auth.service'
import { MatSnackBar } from '@angular/material/snack-bar'
import { catchError, of } from 'rxjs';
import { Router } from '@angular/router';
import { JwtHelperService } from "@auth0/angular-jwt";

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
    /*this.m_Errors.length = 0;
    const dto: LoginDTO = this.loginForm.getRawValue();
    if (!this.loginForm.valid) return;

    this.m_AuthService.login(dto)
      .subscribe(data => {
        if(data){
          if(data.role == 1)this.m_Router.navigate(['/admin-center']);  
          if(data.role == 2)this.m_Router.navigate(['/user']);  
          if(data.role == 3)this.m_Router.navigate(['/admin']);               
        }
      });*/

      const dto: LoginDTO = this.loginForm.getRawValue();

      this.m_AuthService.login2(dto).subscribe((result) => {
        alert("Successful login!");
  
        const token = result;
        localStorage.setItem("token", token.accessToken);
        localStorage.setItem("expiresIn", token.expiresIn);
  
        const jwt: JwtHelperService = new JwtHelperService();
        const info = jwt.decodeToken(token.accessToken);
        const role = info.role;

        if (role === "USER") {
          this.m_Router.navigate(["/user"]);
        }
        else if (role === "ADMIN_CENTER") {
          this.m_Router.navigate(["/admin-center"]);
        }
        else if (role === "ADMIN") {
          this.m_Router.navigate(["/admin"]);
        }
      });
  }

  get formInstance(): UntypedFormGroup {
    return new UntypedFormGroup({
      'username': new UntypedFormControl(null, [Validators.required]),
      'password': new UntypedFormControl(null, [Validators.required])
    });
  }

  get email(){
    return this.loginForm.get('username');
  }

  get password(){
    return this.loginForm.get('password');
  }

  public register(){
    window.location.href="http://localhost:4200/register"
  }

}
