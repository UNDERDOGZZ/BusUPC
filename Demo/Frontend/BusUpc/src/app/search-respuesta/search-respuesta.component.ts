import { Component, OnInit } from '@angular/core';
import { RespuestaService } from '../respuesta.service';
import { Respuesta } from '../model/respuesta';

@Component({
  selector: 'app-search-respuesta',
  templateUrl: './search-respuesta.component.html',
  styleUrls: ['./search-respuesta.component.css']
})
export class SearchRespuestaComponent implements OnInit {

  text:string = "";
  respuestas :Respuesta[];

  constructor(private respuestaService: RespuestaService) { }

  ngOnInit() {
    this.searchRespuesta();
  }

  searchRespuesta(){
  
      this.respuestaService.getRespuestasListOrdered()
      .subscribe(respuestas => this.respuestas = respuestas);
  }
}