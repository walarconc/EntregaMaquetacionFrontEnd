import { Injectable } from '@angular/core';

import { faker } from '@faker-js/faker';

import { Doctor } from '../models/doctor';
@Injectable({
  providedIn: 'root',
})
export class DoctorServiceService {
  public doctores: Doctor[] = [];
  constructor() {
    this.doctores = this.generateDoctores(4);
  }

  generateDoctores(total: number): Doctor[] {
    let doctores: Doctor[] = [];
    for (let i = 0; i < total; i++) {
      doctores.push(
        new Doctor(
          faker.person.firstName(),
          faker.person.lastName(),
          faker.lorem.word(),
          faker.phone.number(),
          faker.lorem.paragraphs(5),
          faker.image.avatar()
        )
      );
    }
    return doctores;
  }
}
