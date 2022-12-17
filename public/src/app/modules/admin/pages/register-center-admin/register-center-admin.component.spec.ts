import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterCenterAdminComponent } from './register-center-admin.component';

describe('RegisterCenterAdminComponent', () => {
  let component: RegisterCenterAdminComponent;
  let fixture: ComponentFixture<RegisterCenterAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterCenterAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegisterCenterAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
