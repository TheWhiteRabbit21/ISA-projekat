import { TestBed } from '@angular/core/testing';

import { RegisterCenterAdminService } from './register-center-admin.service';

describe('RegisterCenterAdminService', () => {
  let service: RegisterCenterAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisterCenterAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
