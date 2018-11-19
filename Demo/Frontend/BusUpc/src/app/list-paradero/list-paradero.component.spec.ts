import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListParaderoComponent } from './list-paradero.component';

describe('ListParaderoComponent', () => {
  let component: ListParaderoComponent;
  let fixture: ComponentFixture<ListParaderoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListParaderoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListParaderoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
