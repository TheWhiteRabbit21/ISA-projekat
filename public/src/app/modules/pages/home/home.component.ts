import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  bloodbanks: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  public showBloodBanks(){
    this.bloodbanks = true;
  }

  public closeBloodBanks(){
    this.bloodbanks = false;
  }

}
