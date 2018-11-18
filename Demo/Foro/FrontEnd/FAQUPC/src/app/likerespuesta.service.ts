import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LikerespuestaService {

  private baseUrl = "http://localhost:8080/likeanswers";

  constructor(private http:HttpClient) { }

  createLikeAnswer(question: Object)
  {
    return this.http.post(`${this.baseUrl}`, question);
  }

  updateLikeAnswer(id: number, value:any):
  Observable<Object>
  {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  getLikeAnswer(ansId:number,studId:number ):Observable<any>{
    return this.http.get(`${this.baseUrl}/answer/${ansId}/student/${studId}`);
  }
}

