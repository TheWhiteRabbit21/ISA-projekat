import { TestBed, async, inject } from '@angular/core/testing';
import { CenterService } from './reserve-appointment-list.service';

describe('Service: Center', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CenterService]
    });
  });

  it('should ...', inject([CenterService], (service: CenterService) => {
    expect(service).toBeTruthy();
  }));
});
