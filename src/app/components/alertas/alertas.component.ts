import { Component } from '@angular/core';

import { AlertasServiceService } from '../../services/alertas-service.service';
import { Alerta } from '../../models/alertas';

@Component({
  selector: 'app-alertas',
  templateUrl: './alertas.component.html',
  styleUrls: ['./alertas.component.scss'],
})
export class AlertasComponent {
  constructor(private alertasService: AlertasServiceService) {}

  get alertas(): Alerta[] {
    return this.alertasService.alertas;
  }

  closeAlerta(alerta: Alerta): void {
    this.alertasService.readAlerta(alerta);
  }
}
