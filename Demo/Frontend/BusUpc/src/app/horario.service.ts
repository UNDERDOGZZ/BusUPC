import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HorarioService {

  private baseURL="http://localhost:8080/horarios";

  constructor(private http:HttpClient) { }


  createHorario(horario: Object):Observable<object>
  {
    return this.http.post(`${this.baseURL}`,horario);
  }

  updateHorario(id: number,value:any):Observable<object>
  {
    return this.http.put(`${this.baseURL}/${id}`,value);
  }


  deleteHorario(id:number):Observable<any>
  {
    return this.http.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }

  getHorariosList():Observable<any>
  {
    return this.http.get(`${this.baseURL}`);
  }

  getHorarioById(id:number):Observable<any>
  {
    return this.http.get(`${this.baseURL}/search/${id}`);
  }

  deleteAll():Observable<any>
  {
    return this.http.delete(`${this.baseURL}`,{responseType: 'text'});
  }

}