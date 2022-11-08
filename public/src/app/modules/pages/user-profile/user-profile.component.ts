import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    //ovde dobavis podatke iz bekenda
  }

  public onOpenModal( mode: string): void {
    const container = document.getElementById('main-container');
    // console.log("KONTEJENR",container);
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if(mode === 'edit'){
      button.setAttribute('data-target', '#editData');
    }
    if(container != null){
      container.appendChild(button);
    }

    button.click();
  }

}
