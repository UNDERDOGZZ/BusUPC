import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateParaderoComponent } from './create-paradero.component';

describe('CreateParaderoComponent', () => {
  let component: CreateParaderoComponent;
  let fixture: ComponentFixture<CreateParaderoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateParaderoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateParaderoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
