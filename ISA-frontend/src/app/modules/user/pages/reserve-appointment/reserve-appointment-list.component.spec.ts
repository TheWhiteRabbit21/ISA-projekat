import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ReserveAppointmentComponent } from "./reserve-appointment.component";

describe('ReserveAppointmentComponent', () => {
  let component: ReserveAppointmentComponent;
  let fixture: ComponentFixture<ReserveAppointmentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ReserveAppointmentComponent]
    })
    .compileComponents();
  }))

  beforeEach(() => {
    fixture = TestBed.createComponent(ReserveAppointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
