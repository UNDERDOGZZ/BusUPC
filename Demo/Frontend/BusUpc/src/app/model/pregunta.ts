import { Usuario } from "./usuario";

export class Pregunta {
    id:number;
    texto:string;
    rating: number;
    clienteId: Usuario;
}
