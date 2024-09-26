import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/models/doctor';
import { DoctorServiceService } from 'src/app/services/doctor-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-doctores',
  templateUrl: './lista-doctores.component.html',
  styleUrls: ['./lista-doctores.component.css'],
})
export class ListaDoctoresComponent implements OnInit {
  constructor(
    private doctorService: DoctorServiceService,
    private router: Router
  ) {}

  ngOnInit() {}
  // get service doctors

  get doctors(): Doctor[] {
    return this.doctorService.doctores;
  }

  // toggle favorite
  toggleFavorite(doctor: Doctor) {
    doctor.favorito = !doctor.favorito;
  }
  // Go to add
  goToAdd() {
    this.router.navigate(['user/doctores/add']);
  }
  goToDoctor(doctor: Doctor) {
    this.router.navigate(['user/doctores', doctor.id]);
  }
}
