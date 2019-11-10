import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PartTripsComponent } from './part-trips.component';

describe('PartTripsComponent', () => {
  let component: PartTripsComponent;
  let fixture: ComponentFixture<PartTripsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PartTripsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PartTripsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
