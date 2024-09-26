/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AlertasServiceService } from './alertas-service.service';

describe('Service: AlertasService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AlertasServiceService]
    });
  });

  it('should ...', inject([AlertasServiceService], (service: AlertasServiceService) => {
    expect(service).toBeTruthy();
  }));
});
