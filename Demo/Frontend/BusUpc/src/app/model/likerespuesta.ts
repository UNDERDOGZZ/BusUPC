import { Usuario } from "./usuario";
import { Respuesta } from "./respuesta";

export class Likerespuesta {
    id:number;
    respuestaId: Respuesta;
    clienteId: Usuario;
    liked: boolean; 
}
