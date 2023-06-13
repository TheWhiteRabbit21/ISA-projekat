/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PredefinedAppointmentsCenterService } from './predefined-appointments-center.service';

describe('Service: PredefinedAppointmentsCenter', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PredefinedAppointmentsCenterService]
    });
  });

  it('should ...', inject([PredefinedAppointmentsCenterService], (service: PredefinedAppointmentsCenterService) => {
    expect(service).toBeTruthy();
  }));
});
