import { PreguntaService } from './../pregunta.service';
import { Pregunta } from './../model/pregunta';
import { Component, OnInit, Input } from '@angular/core';
import { SearchPreguntaComponent } from '../search-pregunta/search-pregunta.component';
import { RespuestaListaComponent } from '../respuesta-lista/respuesta-lista.component';

@Component({
  selector: 'app-pregunta-detalle',
  templateUrl: './pregunta-detalle.component.html',
  styleUrls: ['./pregunta-detalle.component.css']
})
export class PreguntaDetalleComponent implements OnInit {

  @Input() pregunta: Pregunta;

  constructor(private preguntaService: PreguntaService,
    private listComponent: SearchPreguntaComponent) { }

  ngOnInit() {
  }

  deleteQuestion(){
    this.preguntaService.deleteQuestion(this.pregunta.id)
    .subscribe(
      data=>{
        this.listComponent.searchPatient();
      },
      error => console.log(error));
  
  }
}