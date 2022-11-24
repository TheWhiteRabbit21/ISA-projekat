/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BloodDonorFormService } from './blood-donor-form.service';

describe('Service: BloodDonorForm', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BloodDonorFormService]
    });
  });

  it('should ...', inject([BloodDonorFormService], (service: BloodDonorFormService) => {
    expect(service).toBeTruthy();
  }));
});
