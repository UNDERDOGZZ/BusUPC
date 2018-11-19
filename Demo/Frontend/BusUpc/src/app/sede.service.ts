import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SedeService {
  private baseURL ="http://localhost:8080/sedes";

  constructor(private http:HttpClient) { }

  getSede(id:number):Observable<object>
  {
    return this.http.get(`${this.baseURL}/${id}`);
  }

  createSede(sede:Object): Observable<object>
  {
    return this.http.post(`${this.baseURL}`,sede);
  }

  updateSede(id: number, value:any): Observable<object>
  {
    return this.http.put(`${this.baseURL}/${id}`,value);
  }

  deleteSede(id:number):Observable<any>
  {
    return this.http.delete(`${this.baseURL}/${id}`,{responseType: 'text'});
  }

  getSedeList():Observable<any>
  {
    return this.http.get(`${this.baseURL}`);
  }

  getSedeBySede(sede:string):Observable<any>
  {
    return this.http.get(`${this.baseURL}/${sede}`);
  }

  deleteAll():Observable<any>
  {
    return this.http.delete(`${this.baseURL}`,{responseType: 'text'});
  }

}
