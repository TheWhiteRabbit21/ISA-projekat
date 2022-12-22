import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { tap } from 'rxjs';
import { Appointment, Center, UpdateCenterService } from './admin-center-profile.service';

@Component({
  selector: 'app-admin-center-profile',
  templateUrl: './admin-center-profile.component.html',
  styleUrls: ['./admin-center-profile.component.css']
})
export class AdminCenterProfileComponent implements OnInit {

  public center : Center = {
    id : '',
    name : '',
    country : '',
    city : '',
    street : '',
    number : '',
    description : ''
  }

  public appointment : Appointment = {
    id: '',
    date: '',
    time: '',
    durationMinutes: '',
    taken: false
  }

  constructor(
    private updateCenterService : UpdateCenterService,
    private _route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    let id  = this._route.snapshot.paramMap.get('id');
    if(id != null){
      this.center.id = id;
    }
  }

  submit() : void{
    this.updateCenterService.submit(this.center).pipe(
      tap(() => this.router.navigate(['../home']))
      ).subscribe();
  }

}
