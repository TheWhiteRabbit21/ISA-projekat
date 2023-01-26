import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { RegisteredUsersListService, User, Search, Page } from './registered-users-list.service';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { PageEvent } from '@angular/material/paginator';

@Component({
  selector: 'app-registered-users-list',
  templateUrl: './registered-users-list.component.html',
  styleUrls: ['./registered-users-list.component.scss']
})
export class RegisteredUsersListComponent implements OnInit {

  public users: User[] = [];
  public search: Search= {name:'',surname : ''}
  displayedColumns: string[] = ['name', 'surname', 'jmbg', 'email'];
  public length : number = 100;
  public pageSizeOptions : number[] = [10,25,50]
  public dataSource = new MatTableDataSource(this.users);
  public page : Page = {
    pageIndex : 0,
    pageSize : 10
  };
  
  constructor(private _liveAnnouncer: LiveAnnouncer, private _registeredUsersList: RegisteredUsersListService) {}
  
  ngOnInit(): void {
    this.getBloodCenters();
  }

  searchUser(): void {
    this._registeredUsersList.search(this.search).subscribe(res => {
      this.users = res;
      this.dataSource = new MatTableDataSource(this.users);
      this.dataSource.sort = this.sort;      
    });
  }
  public getBloodCenters(){
    this._registeredUsersList.getAllUsers(this.page).subscribe(res => {
      this.users = res;
      this.dataSource = new MatTableDataSource(this.users);
      this.dataSource.sort = this.sort;
    })
  }

  handlePageEvent(e: PageEvent) {
    this.length = e.length;
    this.page.pageSize = e.pageSize;
    this.page.pageIndex = e.pageIndex;
    this.getBloodCenters();
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
