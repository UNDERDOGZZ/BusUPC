import { Pregunta } from "./pregunta";
import { Usuario } from "./usuario";

export class Respuesta {
    id: number;
    response: string;
    rating: number;
    questionId: Pregunta;
    studentId: Usuario;
}
