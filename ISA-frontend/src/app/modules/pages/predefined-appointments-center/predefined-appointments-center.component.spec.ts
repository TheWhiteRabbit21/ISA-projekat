/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { PredefinedAppointmentsCenterComponent } from './predefined-appointments-center.component';

describe('PredefinedAppointmentsCenterComponent', () => {
  let component: PredefinedAppointmentsCenterComponent;
  let fixture: ComponentFixture<PredefinedAppointmentsCenterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PredefinedAppointmentsCenterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PredefinedAppointmentsCenterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
