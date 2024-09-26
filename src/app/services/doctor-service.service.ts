import { Injectable } from '@angular/core';

import { faker } from '@faker-js/faker';

import { Doctor, Cita } from '../models/doctor';

faker.seed(1);

@Injectable({
  providedIn: 'root',
})
export class DoctorServiceService {
  public doctores: Doctor[] = [];
  constructor() {
    this.doctores = this.generateDoctores(4);
  }
  generateCitas(total: number): Cita[] {
    let citas: Cita[] = [];
    for (let i = 0; i < total; i++) {
      citas.push(new Cita(faker.date.recent(), faker.lorem.words(3)));
    }
    return citas;
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
          faker.image.avatar(),
          faker.string.uuid(),
          this.generateCitas(3)
        )
      );
    }
    return doctores;
  }
  getDoctor(id: string): Doctor {
    const doctor = this.doctores.find((doctor) => doctor.id === id);
    if (!doctor) {
      throw new Error(`Doctor with id ${id} not found`);
    }
    return doctor;
  }
}
