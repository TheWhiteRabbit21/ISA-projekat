import { Component, OnInit } from '@angular/core';
import { Center, RegisterCenterService } from './register-center.service';

@Component({
  selector: 'app-register-center',
  templateUrl: './register-center.component.html',
  styleUrls: ['./register-center.component.css']
})
export class RegisterCenterComponent implements OnInit {

  public center : Center = {
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    description : ''
  }

  constructor(private registerCenterService : RegisterCenterService) { }

  ngOnInit(): void {
  }

  submit() : void{
    this.registerCenterService.submit(this.center).subscribe(res => {

    });
  }

}
