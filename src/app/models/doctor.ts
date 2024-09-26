// Doctor model

export class Doctor {
  nombres: string;
  apellidos: string;
  especialidad: string;
  contacto: string;
  perfil: string;
  avatar: string;
  favorito: boolean;
  rating: number;

  constructor(
    nombres: string,
    apellidos: string,
    especialidad: string,
    contacto: string,
    perfil: string,
    avatar: string
  ) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.especialidad = especialidad;
    this.contacto = contacto;
    this.perfil = perfil;
    this.avatar = avatar;
    this.favorito = false;
    this.rating = 0;
  }
}
