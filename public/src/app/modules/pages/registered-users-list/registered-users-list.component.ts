import { LiveAnnouncer } from '@angular/cdk/a11y';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort, Sort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { RegisteredUsersListService, User, Search } from './registered-users-list.service';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-registered-users-list',
  templateUrl: './registered-users-list.component.html',
  styleUrls: ['./registered-users-list.component.scss']
})
export class RegisteredUsersListComponent implements OnInit {

  public users: User[] = [];
  public search: Search= {name:'',surname : ''}
  displayedColumns: string[] = ['name', 'surname', 'jmbg', 'email'];
  public dataSource = new MatTableDataSource(this.users);
  
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
    this._registeredUsersList.getAllUsers().subscribe(res => {
      this.users = res;
      this.dataSource = new MatTableDataSource(this.users);
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
