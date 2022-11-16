/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { BloodBankListService } from './blood-bank-list.service';

describe('Service: BloodBankList', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BloodBankListService]
    });
  });

  it('should ...', inject([BloodBankListService], (service: BloodBankListService) => {
    expect(service).toBeTruthy();
  }));
});
