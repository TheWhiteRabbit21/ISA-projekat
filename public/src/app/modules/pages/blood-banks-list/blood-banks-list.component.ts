import {LiveAnnouncer} from '@angular/cdk/a11y';
import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatSort, Sort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { BloodBankListService } from './blood-bank-list.service';

export interface BloodBank {
  name: string;
  averagePoints: number;
  address: number;
  description: string;
}

@Component({
  selector: 'app-blood-banks-list',
  templateUrl: './blood-banks-list.component.html',
  styleUrls: ['./blood-banks-list.component.css']
})
export class BloodBanksListComponent implements AfterViewInit, OnInit {

  public bloodbanks: BloodBank[] = [];
  displayedColumns: string[] = ['name', 'averagePoints', 'address', 'description'];
  public dataSource = new MatTableDataSource(this.bloodbanks);
  
  constructor(private _liveAnnouncer: LiveAnnouncer, private _bloodBankService: BloodBankListService) {}
  
  ngOnInit(): void {
    this.getBloodCenters();
  }

  public getBloodCenters(){
    this._bloodBankService.getAllBloodCenters().subscribe(res => {
      this.bloodbanks = res;
      this.dataSource = new MatTableDataSource(this.bloodbanks);
      this.dataSource.sort = this.sort;
    })
  }

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
