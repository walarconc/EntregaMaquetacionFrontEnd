import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DoctoresComponent} from "./components/doctores/doctores.component";
import {AlertasComponent} from "./components/alertas/alertas.component";
import {RegistroComponent} from "./components/registro/registro.component";
import {SidenavComponent} from "./components/sidenav/sidenav.component";
import {PerfilComponent} from "./components/perfil/perfil.component";
import {InformesComponent} from "./components/informes/informes.component";


const routes: Routes = [
  { path: 'user', component: SidenavComponent,
    children: [
      {
        path: 'doctores',
        component: DoctoresComponent
      },
      {
        path: 'alertas',
        component: AlertasComponent
      },
      {
        path: 'perfil',
        component: PerfilComponent
      },
      {
        path: 'informes',
        component: InformesComponent
      }
    ]},
  { path: '', component: RegistroComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
