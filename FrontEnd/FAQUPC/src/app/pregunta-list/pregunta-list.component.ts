import { PreguntaService } from './../pregunta.service';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregunta } from '../model/pregunta';

@Component({
  selector: 'app-pregunta-list',
  templateUrl: './pregunta-list.component.html',
  styleUrls: ['./pregunta-list.component.css']
})
export class PreguntaListComponent implements OnInit {

  preguntas:Pregunta[];

  constructor(private preguntaService: PreguntaService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.preguntaService.getQuestionsListOrdered()
    .subscribe(preguntas => this.preguntas = preguntas);
  }
}
