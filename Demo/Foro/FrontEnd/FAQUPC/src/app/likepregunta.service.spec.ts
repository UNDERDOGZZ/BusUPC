import { TestBed } from '@angular/core/testing';

import { LikepreguntaService } from './likepregunta.service';

describe('LikepreguntaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LikepreguntaService = TestBed.get(LikepreguntaService);
    expect(service).toBeTruthy();
  });
});
