import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatFormField } from '@angular/material/form-field';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { map, Observable, switchMap, tap } from 'rxjs';
import { AuthService } from '../pages/login/log-auth.service';
import { UserDataService } from '../pages/login/log-user-data.service';
import { AdminService, PasswordDTO } from './admin.service';

export interface Password {
  new: string;
  confirm: string;
}

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  new: string = '';
  confirm: string = '';
  visible: boolean = true;
  password: PasswordDTO = {
    password : '',
    id : 0
  }

  constructor(public dialog: MatDialog, private snackBar: MatSnackBar, private adminService: AdminService, private m_AuthService : AuthService
    ,private m_Router : Router, private m_UserDataService : UserDataService) { }

  ngOnInit(): void {
    this.m_UserDataService.m_UserData$.pipe(tap(user_data => {
      if(user_data)this.password.id = user_data.id;
      console.log(this.password.id);
    }),switchMap(_ => this.getIfChanged())).subscribe();
  }
  getIfChanged():Observable<any> {
    return this.adminService.getIfPasswordChanged(this.password.id).pipe(tap(res =>{
      this.visible = !res;
    }),switchMap(_ => this.initate()));    
  }
  initate(): Observable<any>{
    if(this.visible){
      const dialogRef = this.dialog.open(ChangePasswordDialog, {
        data: {new: this.new, password: this.confirm},
      });
      dialogRef.disableClose = true;
      return dialogRef.afterClosed().pipe(map(result  => {
        this.new = result.new;
        this.confirm = result.confirm;
        this.password.password = result.new;
      }),switchMap(_ => this.changePassword()));
    }
    return new Observable<any>;
  }
  changePassword(): Observable<any>{
    return this.adminService.changePassword(this.password).pipe(tap(_ => {
      this.snackBar.open('Password Successfully Changed','Ok', {
        duration: 3000
      })
    }));

  }
  logout(): void {
    this.m_AuthService.logout();
    this.m_Router.navigate(['/login']);
  }
}
@Component({
  selector: 'change-password',
  templateUrl: 'change-password.html',
})

export class ChangePasswordDialog {
  flag: boolean = true;
  constructor(
    public dialogRef: MatDialogRef<ChangePasswordDialog>,
    @Inject(MAT_DIALOG_DATA) public data: Password,
  ) {}
  check(): void{
    if(!this.data.new){
      this.flag = true;
      return;
    }
    if(!this.data.confirm){
      this.flag = true;
      return;
    }
    if(this.data.new != this.data.confirm){
      this.flag = true;
      return;
    }
    this.flag = false;
  }
}

