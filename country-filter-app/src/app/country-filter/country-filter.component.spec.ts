import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CountryFilterComponent } from './country-filter.component';

describe('CountryFilterComponent', () => {
  let component: CountryFilterComponent;
  let fixture: ComponentFixture<CountryFilterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CountryFilterComponent]
    });
    fixture = TestBed.createComponent(CountryFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
