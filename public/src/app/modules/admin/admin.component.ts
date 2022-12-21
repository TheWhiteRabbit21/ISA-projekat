import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatFormField } from '@angular/material/form-field';
import { AdminService } from './admin.service';

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

  constructor(public dialog: MatDialog, private adminService: AdminService) { }

  ngOnInit(): void {
    //this.adminService.getIfPasswordChanged().subscribe(res =>{
    //  this.visible = res;
    //});
    if(this.visible){
      const dialogRef = this.dialog.open(ChangePasswordDialog, {
        data: {new: this.new, password: this.confirm},
      });
      dialogRef.disableClose = true;
      dialogRef.afterClosed().subscribe(result => {
        this.new = result.new;
        this.confirm = result.confirm;
      });
    }
  }
  logout(): void {
  }
}
@Component({
  selector: 'change-password',
  templateUrl: 'change-password.html',
})

export class ChangePasswordDialog {
  constructor(
    public dialogRef: MatDialogRef<ChangePasswordDialog>,
    @Inject(MAT_DIALOG_DATA) public data: Password,
  ) {}

}

