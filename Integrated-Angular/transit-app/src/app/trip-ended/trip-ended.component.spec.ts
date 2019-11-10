import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TripEndedComponent } from './trip-ended.component';

describe('TripEndedComponent', () => {
  let component: TripEndedComponent;
  let fixture: ComponentFixture<TripEndedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TripEndedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TripEndedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
