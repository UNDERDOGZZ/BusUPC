import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";

export class Likepregunta {
    id:number;
    preguntaId: Pregunta;
    clienteId: Usuario;
    liked: boolean; 
}
