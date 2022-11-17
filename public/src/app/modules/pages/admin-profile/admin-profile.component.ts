import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { tap } from 'rxjs';
import { Admin, UpdateAdminService } from './admin-profile.service';

export interface AdminInfo {
  name: string;
  surname: string;
  jmbg: number;
  address: string;
  city: string;
  state: string;
  phoneNumber: string;
}



const ELEMENT_DATA: AdminInfo[] = [
  {name: 'Petar', surname: 'Petrović', jmbg: 2506997202356, address: 'Bulevar Oslobođenja 37', city: 'Novi Sad', state: 'Srbija', phoneNumber: '38643366462'}
];




@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit{
  
  public admin : Admin = {
    id: '',
    name: '',
    surname: '',
    password: ' ',
    email: '',
    gender: '',
    jmbg: 0,
    country: '',
    city: '',
    street: '',
    number: '',
    phoneNumber: ''
  }

  displayedColumns: string[] = ['name', 'surname', 'jmbg', 'address', 'city', 'state', 'phoneNumber'];
  dataSource = ELEMENT_DATA;

  constructor(
    private updateAdminService : UpdateAdminService,
    private _route: ActivatedRoute,
    private router: Router
    ) { }

  ngOnInit(): void {
    let id  = this._route.snapshot.paramMap.get('id');
    if(id != null){
      this.admin.id = id;
    }
  }

  submit() : void{
    this.updateAdminService.submit(this.admin).pipe(
      tap(() => this.router.navigate(['../home']))
      ).subscribe();
  }






}
