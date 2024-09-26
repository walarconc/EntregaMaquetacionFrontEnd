import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { DoctoresComponent } from './components/doctores/doctores.component';
import { AlertasComponent } from './components/alertas/alertas.component';
import { MatInputModule } from '@angular/material/input';
import { RegistroComponent } from './components/registro/registro.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { InformesComponent } from './components/informes/informes.component';
import { ListaDoctoresComponent } from './components/lista-doctores/lista-doctores.component';
import { DetalleDoctorComponent } from './components/detalle-doctor/detalle-doctor.component';
import { StarRatingComponent } from './components/star-rating/star-rating.component';
import { MatDividerModule } from '@angular/material/divider';

@NgModule({
  declarations: [
    AppComponent,
    DoctoresComponent,
    AlertasComponent,
    RegistroComponent,
    SidenavComponent,
    PerfilComponent,
    InformesComponent,
    ListaDoctoresComponent,
    DetalleDoctorComponent,
    StarRatingComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatInputModule,
    MatDividerModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [MatIconModule],
})
export class AppModule {}
