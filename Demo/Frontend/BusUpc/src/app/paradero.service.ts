import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ParaderoService {

  private baseUrl = "http://localhost:8080/paraderos";
  
  constructor(private http:HttpClient) { }

  getParadero(id:number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`)
  }

  createParadero(paradero:Object):Observable<Object> {
    return this.http.post(`${this.baseUrl}`,paradero);
  }

  upadteParadero(id:number,value:any):Observable<Object>{
    return this.http.put(`${this.baseUrl}/${id}`,value);
  }

  deleteParadero(id:number):Observable<any>{
    return this.http.delete(`${this.baseUrl}/${id}`,{responseType: 'text'});
  }

  getParaderoList():Observable<any>{
    return this.http.get(`${this.baseUrl}`);
  }

  deleteAll():Observable<any>{
    return this.http.delete(`${this.baseUrl}`,{responseType: 'text'});
  }
}
