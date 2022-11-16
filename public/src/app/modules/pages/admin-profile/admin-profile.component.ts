import { Component, OnInit } from '@angular/core';

export interface AdminInfo {
  name: string;
  surname: string;
  jmbg: number;
  address: string;
  city: string;
  state: string;
  phoneNumber: number;
}

const ELEMENT_DATA: AdminInfo[] = [
  {name: 'Petar', surname: 'Petrović', jmbg: 2506997202356, address: 'Bulevar Oslobođenja 37', city: 'Novi Sad', state: 'Srbija', phoneNumber: 38643366462}
];




@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent {
  
  displayedColumns: string[] = ['name', 'surname', 'jmbg', 'address', 'city', 'state', 'phoneNumber'];
  dataSource = ELEMENT_DATA;

}
