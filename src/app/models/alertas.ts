export class Alerta {
  fecha: Date;
  mensaje: string;
  titulo: string;
  id: string;

  constructor(fecha: Date, titulo: string, mensaje: string, id: string) {
    this.fecha = fecha;
    this.mensaje = mensaje;
    this.titulo = titulo;
    this.id = id;
  }
}
