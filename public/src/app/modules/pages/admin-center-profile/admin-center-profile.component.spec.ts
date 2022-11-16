import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCenterProfileComponent } from './admin-center-profile.component';

describe('AdminCenterProfileComponent', () => {
  let component: AdminCenterProfileComponent;
  let fixture: ComponentFixture<AdminCenterProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminCenterProfileComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminCenterProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
