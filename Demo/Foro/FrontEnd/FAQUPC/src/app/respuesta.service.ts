import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class RespuestaService {
  private baseUrl = "http://localhost:8080/answers";

  constructor(private http:HttpClient) { }


  createRespuesta(respuesta: Object)
  {
    return this.http.post(`${this.baseUrl}`, respuesta);
  }

  updateRespuesta(id: number, value:any):
  Observable<Object>
  {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteRespuesta(id: number): Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType:
      'text'});
  }

  getRespuestasList():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  getRespuestasListOrdered():Observable<any>{
    return this.http.get(`${this.baseUrl}/ordered`);
  }

  getRespuestasPorPregunta(id: number):Observable<any>{
    return this.http.get(`${this.baseUrl}/question/${id}`);
  }

}