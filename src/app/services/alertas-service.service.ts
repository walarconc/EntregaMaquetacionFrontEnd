import { Injectable } from '@angular/core';

import { faker } from '@faker-js/faker';

import { Alerta } from '../models/alertas';

faker.seed(1);

@Injectable({
  providedIn: 'root',
})
export class AlertasServiceService {
  public alertas: Alerta[] = [];
  constructor() {
    this.alertas = this.generateAlertas(4);
  }
  generateAlertas(total: number): Alerta[] {
    let alertas: Alerta[] = [];
    for (let i = 0; i < total; i++) {
      alertas.push(
        new Alerta(
          faker.date.recent(),
          faker.lorem.words(3),
          faker.lorem.paragraph(1),
          faker.string.uuid()
        )
      );
    }
    return alertas;
  }

  readAlerta(alerta: Alerta): void {
    this.alertas = this.alertas.filter((a) => a.id !== alerta.id);
  }
}
