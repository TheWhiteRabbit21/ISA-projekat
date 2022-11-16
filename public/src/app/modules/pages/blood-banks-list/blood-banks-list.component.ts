import {LiveAnnouncer} from '@angular/cdk/a11y';
import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

export interface BloodBanks {
  name: string;
  averageRating: number;
  city: string;
  country: string;
  descritpion: string;
}

const ELEMENT_DATA: BloodBanks[] = [
  {name: 'Minotaur', averageRating: 4.50, city: 'Novi Sad', country: 'Srbija', descritpion: 'Mitsko osoblje.'},
  {name: 'Astra', averageRating: 3.80, city: 'Beograd', country: 'Srbija', descritpion: 'Sija.'},
  {name: 'Dunja', averageRating: 2.90, city: 'Split', country: 'Hrvatska', descritpion: 'Divna.'},
  {name: 'Argus', averageRating: 1.20, city: 'Sarajevo', country: 'Bosna i Hercegovina', descritpion: 'Sunce.'},
  {name: 'Mitar', averageRating: 4.82, city: 'Apatin', country: 'Srbija', descritpion: 'Miric.'},
  {name: 'Igla', averageRating: 5.00, city: 'Budva', country: 'Crna Gora', descritpion: 'Boc boc.'}
];

@Component({
  selector: 'app-blood-banks-list',
  templateUrl: './blood-banks-list.component.html',
  styleUrls: ['./blood-banks-list.component.css']
})
export class BloodBanksListComponent implements AfterViewInit {

  displayedColumns: string[] = ['name', 'averageRating', 'city', 'country', 'descritpion'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);

  constructor(private _liveAnnouncer: LiveAnnouncer) {}

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }


}
