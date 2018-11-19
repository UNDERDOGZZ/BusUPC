import { Component, OnInit, Input } from '@angular/core';
import { Pregunta } from './../model/pregunta';
import { PreguntaService } from './../pregunta.service';

@Component({
  selector: 'app-edit-pregunta',
  templateUrl: './edit-pregunta.component.html',
  styleUrls: ['./edit-pregunta.component.css']
})
export class EditPreguntaComponent implements OnInit {

  @Input() pregunta: Pregunta;

  constructor(private preguntaService: PreguntaService) { }

  ngOnInit() {
  }

  editPregunta()
  {
    this.preguntaService.createQuestion(this.pregunta)
    .subscribe(data=>console.log(data),error=>console.log(error));
  }
}
