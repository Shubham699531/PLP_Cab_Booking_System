import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstimatedPriceInfoComponent } from './estimated-price-info.component';

describe('EstimatedPriceInfoComponent', () => {
  let component: EstimatedPriceInfoComponent;
  let fixture: ComponentFixture<EstimatedPriceInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstimatedPriceInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstimatedPriceInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
