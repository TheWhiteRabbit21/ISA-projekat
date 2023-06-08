import {LiveAnnouncer} from '@angular/cdk/a11y';
import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { BloodBankListService } from './blood-bank-list.service';
import { MatPaginator, PageEvent } from '@angular/material/paginator';
import { Page } from '../../admin/pages/registered-users-list/registered-users-list.service';

export interface BloodBank {
  name: string;
  averagePoints: number;
  city: string;
  country: string;
  description: string;
}
export interface SearchCenter {
  name: string;
  city: string;
}

@Component({
  selector: 'app-blood-banks-list',
  templateUrl: './blood-banks-list.component.html',
  styleUrls: ['./blood-banks-list.component.css']
})
export class BloodBanksListComponent implements AfterViewInit, OnInit {
  countries: string[] = [];
  filterCountry: string = 'Reset Country';
  filterAvgPoints: string = 'Reset Rating';
  name: string = '';
  city: string = '';
  public bloodbanks: BloodBank[] = [];
  displayedColumns: string[] = ['name', 'averagePoints', 'city', 'country', 'description'];
  public dataSource = new MatTableDataSource(this.bloodbanks);
  public searchCenter: SearchCenter = {name : '', city : ''}

  public length : number = 100;
  public pageSizeOptions : number[] = [10,25,50]
  public page : Page = {
    pageIndex : 0,
    pageSize : 10
  };
  constructor(private _liveAnnouncer: LiveAnnouncer, private _bloodBankService: BloodBankListService, private http:HttpClient) {}

  ngOnInit(): void {
    this.getBloodCenters();
  }

  handlePageEvent(event: PageEvent) {
    const startIndex = event.pageIndex * event.pageSize;
    this.length = event.length;
    this.page.pageSize = event.pageSize;
    this.page.pageIndex = event.pageIndex;
    this.getBloodCenters()
  }

  public getBloodCenters(){
    this._bloodBankService.getAllBloodCenters(this.page).subscribe(res => {
      this.bloodbanks = res;
      this.dataSource = new MatTableDataSource(this.bloodbanks);
      this.dataSource.sort = this.sort;
      for(let i = 0; i<this.bloodbanks.length; i++){
        this.countries.push(this.bloodbanks[i].country);
      }
    })
  }

  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator;
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }

  searchByName() {
    if(this.name !== ''){
      this.http.get(`http://localhost:8084/api/centers/search_name/${this.name}`).subscribe((res:any) =>{
      this.dataSource = new MatTableDataSource(res);
    })
    } else {
        this.dataSource = new MatTableDataSource(this.bloodbanks);
    }

  }

  searchByCity() {
    if(this.city !== ''){
      this.http.get(`http://localhost:8084/api/centers/search_city/${this.city}`).subscribe((res:any) =>{
      this.dataSource = new MatTableDataSource(res);
    })
    } else {
        this.dataSource = new MatTableDataSource(this.bloodbanks);
    }

  }

  filterByCountry() {
    if(this.filterCountry !== 'Reset Country'){
      this.http.get(`http://localhost:8084/api/centers/filter_country/${this.filterCountry}`).subscribe((res:any) =>{
      this.dataSource = new MatTableDataSource(res);
    });
    } else{
      this.dataSource = new MatTableDataSource(this.bloodbanks);
    }

  }

  filterByAvgPoints() {
    if(this.filterAvgPoints !== 'Reset Rating'){
      this.http.get(`http://localhost:8084/api/centers/filter_avgPoints/${this.filterAvgPoints}`).subscribe((res:any) =>{
      this.dataSource = new MatTableDataSource(res);
    });
    } else{
      this.dataSource = new MatTableDataSource(this.bloodbanks);
    }

  }
  search() {
      this.http.post(`http://localhost:8084/api/centers/search_name_city/`, this.searchCenter).subscribe((res:any) =>{
      this.dataSource = new MatTableDataSource(res);
          })}
}
