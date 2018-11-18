import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchSedeComponent } from './search-sede.component';

describe('SearchSedeComponent', () => {
  let component: SearchSedeComponent;
  let fixture: ComponentFixture<SearchSedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchSedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
