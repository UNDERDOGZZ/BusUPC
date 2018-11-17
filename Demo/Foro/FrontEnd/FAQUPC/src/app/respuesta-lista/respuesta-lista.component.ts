import { RespuestaService } from './../respuesta.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Respuesta } from '../model/respuesta';

@Component({
  selector: 'app-respuesta-lista',
  templateUrl: './respuesta-lista.component.html',
  styleUrls: ['./respuesta-lista.component.css']
})
export class RespuestaListaComponent implements OnInit {

  respuestas:Respuesta[];

  constructor(private respuestaService: RespuestaService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.respuestaService.getRespuestasListOrdered()
    .subscribe(respuestas => this.respuestas = respuestas);
  }
}

