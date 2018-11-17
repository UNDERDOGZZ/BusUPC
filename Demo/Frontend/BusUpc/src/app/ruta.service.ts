import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RutaService {
  private baseURL="http://localhost:8080/rutas";

  constructor(private http:HttpClient) { }

  getRuta(id:number):Observable<object>
  {
    return this.http.get(`${this.baseURL}/${id}`);
  }

  createRuta(ruta: Object):Observable<object>
  {
    return this.http.post(`${this.baseURL}`,ruta);
  }

  updateRuta(id: number,value:any):Observable<object>
  {
    return this.http.put(`${this.baseURL}/${id}`,value);
  }


  deleteRuta(id:number):Observable<any>
  {
    return this.http.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }

  getRutasList():Observable<any>
  {
    return this.http.get(`${this.baseURL}`);
  }

  getRutaById(id:number):Observable<any>
  {
    return this.http.get(`${this.baseURL}/search/${id}`);
  }

  deleteAll():Observable<any>
  {
    return this.http.delete(`${this.baseURL}`,{responseType: 'text'});
  }

}
