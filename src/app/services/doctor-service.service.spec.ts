/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { DoctorServiceService } from './doctor-service.service';

describe('Service: DoctorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DoctorServiceService]
    });
  });

  it('should ...', inject([DoctorServiceService], (service: DoctorServiceService) => {
    expect(service).toBeTruthy();
  }));
});
