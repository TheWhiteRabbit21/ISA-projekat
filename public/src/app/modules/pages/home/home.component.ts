import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/log-auth.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  bloodbanks: boolean = false;
  constructor(private m_AuthService: AuthService) { }

  ngOnInit(): void {
  }

  public showBloodBanks(){
    this.bloodbanks = true;
  }

  public closeBloodBanks(){
    this.bloodbanks = false;
  }

  public bloodDonorForm(){
    window.location.href="http://localhost:4200/blood-donor-form"
  }

  public logout(){
    this.m_AuthService.logout();
    window.location.href="http://localhost:4200/"
  }

}
