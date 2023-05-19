import { Component, OnInit, ViewChild } from '@angular/core';
import { DayService, WeekService, WorkWeekService, MonthService, AgendaService, EventSettingsModel, ResizeService, DragAndDropService, ScheduleComponent } from '@syncfusion/ej2-angular-schedule';
import { Appointment, WorkCalendarService } from './work-calendar.service';


@Component({
  selector: 'app-work-calendar',
  providers: [DayService, WeekService, WorkWeekService, MonthService, AgendaService],
  template: `<div *ngIf="flag"><ejs-schedule [eventSettings]='eventSettings'></ejs-schedule></div>`
})
export class WorkCalendarComponent implements OnInit {
  public flag: boolean = false
  constructor(private workCalendarService: WorkCalendarService) { }
  public eventSettings: EventSettingsModel = {
  };
  ngOnInit(): void {
    this.workCalendarService.getAllAppointments().subscribe(res => {
      this.eventSettings.dataSource = res;
      this.flag = true;
    });
  }
}
