import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutDriverComponent } from './about-driver.component';

describe('AboutDriverComponent', () => {
  let component: AboutDriverComponent;
  let fixture: ComponentFixture<AboutDriverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutDriverComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutDriverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
