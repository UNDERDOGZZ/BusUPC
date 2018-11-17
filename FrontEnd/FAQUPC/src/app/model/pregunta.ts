import { Usuario } from "./usuario";

export class Pregunta {
    id:number;
    text:string;
    rating: number;
    studentId: Usuario;
}
