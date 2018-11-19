import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";

export class Respuesta {
    id: number;
    texto: string;
    rating: number;
    preguntaId: Pregunta;
    clienteId: Usuario;
}
