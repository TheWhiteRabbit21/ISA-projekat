import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ComplaintService, ComplaintDTO } from './complaints.service';

@Component({
  selector: 'app-complaints',
  templateUrl: './complaints.component.html',
  styleUrls: ['./complaints.component.scss']
})
export class ComplaintsComponent implements OnInit {

  public complaints: ComplaintDTO[] = []
  constructor(public dialog: MatDialog, private snackBar: MatSnackBar, private complaintService: ComplaintService) { }

  ngOnInit(): void {
    this.complaintService.getAllUnanswered().subscribe(res => {
      this.complaints = res;
    });
  }

  answer(complaint: ComplaintDTO): void {
    const dialogRef = this.dialog.open(AnswerDialog, {
      data: '',
    });
    dialogRef.disableClose = true;
    dialogRef.afterClosed().subscribe(result => {
      if(result){
        complaint.response = result;
        this.sendAnswer(complaint);
      }
    });
  }
  sendAnswer(complaint: ComplaintDTO): void{
    this.complaintService.answer(complaint).subscribe(_ => {
      this.snackBar.open('Complaint Answered Successfully','Ok', {
        duration: 3000
      });
    });
  }
}

@Component({
  selector: 'answer-complaint',
  templateUrl: 'answer-complaint.html',
})

export class AnswerDialog {
  constructor(
    public dialogRef: MatDialogRef<AnswerDialog>,
    @Inject(MAT_DIALOG_DATA) public data: string,
  ) {}

}