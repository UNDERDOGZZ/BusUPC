import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSedeComponent } from './create-sede.component';

describe('CreateSedeComponent', () => {
  let component: CreateSedeComponent;
  let fixture: ComponentFixture<CreateSedeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSedeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSedeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
