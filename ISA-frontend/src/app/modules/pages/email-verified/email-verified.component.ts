import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { RegisterUserService } from '../register/register-user.service';

@Component({
  selector: 'app-email-verified',
  templateUrl: './email-verified.component.html',
  styleUrls: ['./email-verified.component.css']
})
export class EmailVerifiedComponent implements OnInit {

  message: any;
  username: any;

  constructor(private route: ActivatedRoute, private registerUserService: RegisterUserService) { }

  ngOnInit() {
    this.route.params.subscribe((params: Params)=>{
      this.username = params['id']
      this.registerUserService.verifyEmail(this.username).subscribe(res =>{
        if(res == true){
          this.message = this.username +  ", you have successfully verified your email!";
        }else{
          this.message = this.username +  ", there is no user with that email! Register first and then verify email.";
        }
       })
    });
  }

  public login(){
    window.location.href="http://localhost:4200/login"
  }

}
