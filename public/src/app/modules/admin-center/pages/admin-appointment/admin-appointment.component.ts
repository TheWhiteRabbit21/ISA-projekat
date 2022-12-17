import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-admin-appointment',
  templateUrl: './admin-appointment.component.html',
  styleUrls: ['./admin-appointment.component.scss']
})
export class AdminAppointmentComponent implements OnInit {
  id: number | undefined;

  constructor(private _route: ActivatedRoute,
              private _router: Router) { }

  ngOnInit(): void {
    this._route.params
    .subscribe((params: Params) => {
      this.id = +params['id'];
      //console.log(this.id);
    });
  }

  onBack(): void {
    this._router.navigate(['/admin-center']);
  }


}
