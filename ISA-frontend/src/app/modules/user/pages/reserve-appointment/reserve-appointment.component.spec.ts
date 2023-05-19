import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReserveAppointmentComponent } from './reserve-appointment.component';

describe('ReserveAppointmentComponent', () => {
  let component: ReserveAppointmentComponent;
  let fixture: ComponentFixture<ReserveAppointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReserveAppointmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReserveAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
