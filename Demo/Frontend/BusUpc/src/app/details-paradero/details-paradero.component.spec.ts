import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsParaderoComponent } from './details-paradero.component';

describe('DetailsParaderoComponent', () => {
  let component: DetailsParaderoComponent;
  let fixture: ComponentFixture<DetailsParaderoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsParaderoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsParaderoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
