import { TestBed } from '@angular/core/testing';

import { LikerespuestaService } from './likerespuesta.service';

describe('LikerespuestaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LikerespuestaService = TestBed.get(LikerespuestaService);
    expect(service).toBeTruthy();
  });
});
