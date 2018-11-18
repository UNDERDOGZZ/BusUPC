import { RespuestaService } from './../respuesta.service';
import { Component, OnInit, Input} from '@angular/core';
import { Observable } from 'rxjs';
import { Respuesta } from '../model/respuesta';
import { Pregunta } from '../model/pregunta';

@Component({
  selector: 'app-respuesta-lista',
  templateUrl: './respuesta-lista.component.html',
  styleUrls: ['./respuesta-lista.component.css']
})
export class RespuestaListaComponent implements OnInit {

  @Input() pregunta: Pregunta;

  respuestas:Respuesta[];

  constructor(private respuestaService: RespuestaService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.respuestaService.getRespuestasPorPregunta(this.pregunta.id).subscribe(respuestas => this.respuestas = respuestas);
  }
}

