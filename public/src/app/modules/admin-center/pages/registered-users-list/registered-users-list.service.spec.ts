import { TestBed } from '@angular/core/testing';

import { RegisteredUsersListService } from './registered-users-list.service';

describe('RegisteredUsersListService', () => {
  let service: RegisteredUsersListService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegisteredUsersListService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
