import { TestBed } from '@angular/core/testing';

import { CandidateDashboardService } from './candidate-dashboard.service';

describe('CandidateDashboardService', () => {
  let service: CandidateDashboardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CandidateDashboardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
