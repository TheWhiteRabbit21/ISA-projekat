import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodDonorsListComponent } from './blood-donors-list.component';

describe('BloodDonorsListComponent', () => {
  let component: BloodDonorsListComponent;
  let fixture: ComponentFixture<BloodDonorsListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BloodDonorsListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BloodDonorsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
