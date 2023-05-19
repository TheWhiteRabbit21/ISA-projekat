import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  public register(){
    window.location.href="http://localhost:4200/register"
  }
  public login(){
    window.location.href="http://localhost:4200/login"
  }
}
