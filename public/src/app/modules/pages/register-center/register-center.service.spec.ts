import { TestBed } from '@angular/core/testing';

import { RegisterCenterService } from './register-center.service';

describe('RegisterCenterService', () => {
  let service: RegisterCenterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterCenterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
