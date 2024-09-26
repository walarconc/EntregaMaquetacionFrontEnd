// Doctor model
export class Cita {
  fecha: Date;
  nombre: string;

  constructor(fecha: Date, nombre: string) {
    this.fecha = fecha;
    this.nombre = nombre;
  }
}

export class Doctor {
  nombres: string;
  apellidos: string;
  especialidad: string;
  contacto: string;
  perfil: string;
  avatar: string;
  favorito: boolean;
  rating: number;
  id: string;
  citas: Cita[];

  constructor(
    nombres: string,
    apellidos: string,
    especialidad: string,
    contacto: string,
    perfil: string,
    avatar: string,
    id: string,
    citas: Cita[]
  ) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.especialidad = especialidad;
    this.contacto = contacto;
    this.perfil = perfil;
    this.avatar = avatar;
    this.favorito = false;
    this.rating = 0;
    this.id = id;
    this.citas = citas;
  }

  get fullname(): string {
    return `${this.nombres} ${this.apellidos}`;
  }
}
