import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegdriverComponent } from './regdriver.component';

describe('RegdriverComponent', () => {
  let component: RegdriverComponent;
  let fixture: ComponentFixture<RegdriverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegdriverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegdriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
