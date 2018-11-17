import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsRutaComponent } from './details-ruta.component';

describe('DetailsRutaComponent', () => {
  let component: DetailsRutaComponent;
  let fixture: ComponentFixture<DetailsRutaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailsRutaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailsRutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
