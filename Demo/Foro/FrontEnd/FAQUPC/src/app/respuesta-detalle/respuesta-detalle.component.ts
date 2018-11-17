import { RespuestaService } from './../respuesta.service';
import { Respuesta } from './../model/respuesta';
import { Component, OnInit, Input } from '@angular/core';
import { RespuestaListaComponent } from '../respuesta-lista/respuesta-lista.component';
@Component({
  selector: 'app-respuesta-detalle',
  templateUrl: './respuesta-detalle.component.html',
  styleUrls: ['./respuesta-detalle.component.css']
})
export class RespuestaDetalleComponent implements OnInit {

  @Input() respuesta: Respuesta;

  constructor(private respuestaService: RespuestaService,
    private listComponent: RespuestaListaComponent) { }

  ngOnInit() {
  }

  deleteRespuesta(){
  
  }
}