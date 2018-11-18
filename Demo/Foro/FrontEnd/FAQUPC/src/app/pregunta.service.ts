import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pregunta } from './model/pregunta';
@Injectable({
  providedIn: 'root'
})
export class PreguntaService {

  private baseUrl = "http://localhost:8080/questions";

  constructor(private http:HttpClient) { }

  getQuestion(id:number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`)
  }

  createQuestion(question: Object)
  {
    return this.http.post(`${this.baseUrl}`, question);
  }

  updateQuestion(id: number, value:Pregunta):
  Observable<Object>
  {
    return this.http.put(`${this.baseUrl}/up/${id}`, value);
  }

  deleteQuestion(id: number): Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/${id}`, {responseType:
      'text'});
  }

  getQuestionsList():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  getQuestionByText(text:string):Observable<any>{
    return this.http.get(`${this.baseUrl}/search/${text}`);
  }

  getQuestionsListOrdered():Observable<any>{
    return this.http.get(`${this.baseUrl}/ordered`);
  }

 
}
