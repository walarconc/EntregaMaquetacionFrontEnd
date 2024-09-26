import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Doctor } from 'src/app/models/doctor';
import { DoctorServiceService } from 'src/app/services/doctor-service.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-detalle-doctor',
  templateUrl: './detalle-doctor.component.html',
  styleUrls: ['./detalle-doctor.component.css'],
})
export class DetalleDoctorComponent implements OnInit {
  private doctorId: string;

  constructor(
    private route: ActivatedRoute,
    private doctorService: DoctorServiceService,
    private location: Location
  ) {
    this.doctorId =
      this.route.snapshot.paramMap.get('id') || doctorService.doctores[0].id;
  }

  ngOnInit() {}

  get doctor(): Doctor {
    return this.doctorService.getDoctor(this.doctorId);
  }

  goBack() {
    this.location.back();
  }
}
