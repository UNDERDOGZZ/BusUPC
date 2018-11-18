import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsSedeComponent } from './details-sede.component';

describe('DetailsSedeComponent', () => {
  let component: DetailsSedeComponent;
  let fixture: ComponentFixture<DetailsSedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsSedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
