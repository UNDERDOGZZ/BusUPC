import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";

export class Likepregunta {
    id:number;
    questionId: Pregunta;
    studentId: Usuario;
    liked: boolean; 
}
