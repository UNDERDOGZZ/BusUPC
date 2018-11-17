import { Pregunta } from "./pregunta";

export class Respuesta {
    id: number;
    response: string;
    rating: number;
    questionId: Pregunta;
}
