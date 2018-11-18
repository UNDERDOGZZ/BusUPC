import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LikepreguntaService {

  private baseUrl = "http://localhost:8080/likequestions";

  constructor(private http:HttpClient) { }

  createLikeQuestion(question: Object)
  {
    return this.http.post(`${this.baseUrl}`, question);
  }

  updateLikeQuestion(id: number, value:any):
  Observable<Object>
  {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  getLikeQuestion(questId:number, studId:number ):Observable<any>{
    return this.http.get(`${this.baseUrl}/question/${questId}/student/${studId}`);
  }

  deleteInBulk(id: number): Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/question/${id}`, {responseType:
      'text'});
  }
}