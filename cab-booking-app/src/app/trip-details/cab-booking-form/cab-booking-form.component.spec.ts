import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CabBookingFormComponent } from './cab-booking-form.component';

describe('CabBookingFormComponent', () => {
  let component: CabBookingFormComponent;
  let fixture: ComponentFixture<CabBookingFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CabBookingFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CabBookingFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
